package co.kr.sharek.project.repository;

import co.kr.sharek.common.constants.enums.UserAuthEnum;
import co.kr.sharek.common.constants.enums.UserStateEnum;
import co.kr.sharek.config.config.QueryDslConfig;
import co.kr.sharek.project.domain.QUser;
import co.kr.sharek.project.dto.RankDto;
import co.kr.sharek.project.dto.common.ReqPageDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final QueryDslConfig queryDslConfig;

    QUser user = QUser.user;

    @Override
    public List<RankDto> findPaging(ReqPageDto pageDto) {
        QUser user1 = new QUser("user1");

        JPQLQuery<Long> rankSubQuery = JPAExpressions
                .select(user1.point.count().add(1))
                .from(user1)
                .where(user1.point.gt(user.point));

        NumberExpression<Long> rankExpression = Expressions.numberTemplate(Long.class, "({0})", rankSubQuery);

        return queryDslConfig.jpaQueryFactory()
                .select(Projections.fields(RankDto.class,
                        user.id
                      , user.name
                      , user.nickname
                      , user.img
                      , user.profill
                      , user.point
                      , rankExpression.as("rank")
                ))
                .from(user)
                .where(user.name.contains(pageDto.getName()))
                .where(user.state.eq(UserStateEnum.ACTIVE))
                .where(user.auth.ne(UserAuthEnum.ROLE_ADMIN))
                .offset(pageDto.getCurrentPage())
                .limit(pageDto.getPerPage())
                .orderBy(user.point.desc())
                .orderBy(user.modDt.desc())
                .fetch();
    }

    @Override
    public Long findTotal(ReqPageDto pageDto){
        return queryDslConfig.jpaQueryFactory()
                .select(user.count())
                .from(user)
                .where(user.name.contains(pageDto.getName()))
                .where(user.state.eq(UserStateEnum.ACTIVE))
                .where(user.auth.ne(UserAuthEnum.ROLE_ADMIN))
                .fetchFirst();
    }
}

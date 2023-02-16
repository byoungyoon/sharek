package co.kr.sharek.project.repository;

import co.kr.sharek.common.constants.enums.UserAuthEnum;
import co.kr.sharek.common.constants.enums.UserStateEnum;
import co.kr.sharek.config.config.QueryDslConfig;
import co.kr.sharek.project.domain.QUser;
import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.dto.common.ReqPageDto;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final QueryDslConfig queryDslConfig;

    QUser user = QUser.user;

    @Override
    public List<User> findPaging(ReqPageDto pageDto) {
        return queryDslConfig.jpaQueryFactory()
                .select(Projections.fields(User.class,
                        user.id
                      , user.name
                      , user.nickname
                      , user.img
                      , user.profill
                      , user.point
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

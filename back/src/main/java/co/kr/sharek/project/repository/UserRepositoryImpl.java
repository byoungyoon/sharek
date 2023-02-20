package co.kr.sharek.project.repository;

import co.kr.sharek.common.constants.enums.UserAuthEnum;
import co.kr.sharek.common.constants.enums.UserStateEnum;
import co.kr.sharek.config.config.QueryDslConfig;
import co.kr.sharek.project.domain.QUser;
import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.dto.common.ReqPageDto;
import co.kr.sharek.project.dto.user.ReqRankDto;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Primary
@Slf4j
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final QueryDslConfig queryDslConfig;

    QUser user = QUser.user;

    @Override
    public List<User> findPaging(ReqPageDto pageDto) {

        List<User> userList = queryDslConfig.jpaQueryFactory()
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

        for (long i = 0; i < userList.size(); i++) {
            userList.get((int) i).setRank((i + 1));
        }

        return userList;
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

    public List<User> findToUserRank(ReqRankDto rankDto){
//        // 현재 로그인된 사용자의 정보를 얻음
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        // 현재 로그인된 사용자의 ID를 얻음
//        String currentUserId = userDetails.getUsername();
//
//        if(!id.equals(currentUserId)){
//            return null;
//        }

        List<User> userList = queryDslConfig.jpaQueryFactory()
                .select(Projections.fields(User.class,
                        user.id
                        , user.name
                        , user.nickname
                        , user.img
                        , user.profill
                        , user.point
                ))
                .from(user)
                .where(user.state.eq(UserStateEnum.ACTIVE))
                .where(user.auth.ne(UserAuthEnum.ROLE_ADMIN))
                .orderBy(user.point.desc())
                .orderBy(user.modDt.desc())
                .fetch();

        for (long i = 0; i < userList.size(); i++) {
            userList.get((int) i).setRank((i + 1));
        }

        User data = userList.stream()
                .filter(user -> user.getId().equals(rankDto.getId()))
                .findFirst()
                .orElse(null);

        log.info("내 랭킹 데이터 = {}", data);

        List<User> result = new ArrayList<>();
        result.add(data);

        return result;
    }
}

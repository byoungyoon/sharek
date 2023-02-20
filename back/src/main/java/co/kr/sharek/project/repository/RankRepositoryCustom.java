package co.kr.sharek.project.repository;

import co.kr.sharek.project.dto.user.ReqRankDto;

import java.util.List;

public interface RankRepositoryCustom<T> {
    List<T> findToUserRank(ReqRankDto rankDto);
}

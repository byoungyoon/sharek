package co.kr.sharek.project.repository;

import co.kr.sharek.project.dto.common.ReqPageDto;

import java.util.List;

/**
 * page repository custom (인터페이스 용)
 * @param <T>
 */
public interface PageRepositoryCustom<T> {
    List<T> findPaging(ReqPageDto pageDto);
    Long findTotal(ReqPageDto pageDto);
}

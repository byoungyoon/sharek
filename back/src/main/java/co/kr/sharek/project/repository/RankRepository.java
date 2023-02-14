package co.kr.sharek.project.repository;

import co.kr.sharek.project.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RankRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT (SELECT COUNT(*) + 1 FROM CM_USER a WHERE point > b.point) rank, id, point, name " +
            "FROM CM_USER b " +
            "WHERE nickname = :nickname " +
            "ORDER BY rank asc"
            ,nativeQuery = true)
    Page<RankSummary> getSearchNickname(@Param("nickname") String nickname, Pageable pageable);

    @Query(value = "SELECT (SELECT COUNT(*) + 1 FROM CM_USER a WHERE point > b.point) rank, id, point, name FROM CM_USER b ORDER BY rank asc"
            ,countQuery = "SELECT count(*) FROM CM_USER"
            ,nativeQuery = true)
    Page<RankSummary> getRankingList(Pageable pageable);
}

package co.kr.sharek.project.repository;

import co.kr.sharek.config.security.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankRepositoryTest extends JpaRepository<Member, Long> {

//    Page<Member> findByNickname(String nickname, Pageable pageable);
//
//    Page<Member> findByOrderByPointDesc(Pageable pageable);
//
//    List<Member> findAllByOrderByPointDesc();
//
//    @Query(value = "SELECT (SELECT COUNT(*) + 1 FROM Member a WHERE point > b.point) rank, id, point, name FROM Member b ORDER BY rank desc"
//            ,nativeQuery = true)
//    List<Member> findAll();

    @Query(value = "SELECT (SELECT COUNT(*) + 1 FROM Member a WHERE point > b.point) rank, id, point, name FROM Member b ORDER BY rank desc"
            ,nativeQuery = true)
    Page<RankSummary> findAllBY(Pageable pageable);

}

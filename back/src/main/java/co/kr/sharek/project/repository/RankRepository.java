package co.kr.sharek.project.repository;

import co.kr.sharek.project.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankRepository extends JpaRepository<User, String> {

    Page<RankSummary> findByNickname(String nickname, Pageable pageable);
    Page<RankSummary> findByOrderByPointDesc(Pageable pageable);
}

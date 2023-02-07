package co.kr.sharek.project.repository;

import co.kr.sharek.config.security.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepositoryTest extends JpaRepository<Member, String> {

    Page<RankSummary> findByNicknameContainingOrderByPointDesc(String nickname, Pageable pageable);
    Page<RankSummary> findByOrderByPointDesc(Pageable pageable);
}

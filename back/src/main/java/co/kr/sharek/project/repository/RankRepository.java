package co.kr.sharek.project.repository;

import co.kr.sharek.config.security.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankRepository extends JpaRepository<Member, Long> {
    Page<RankMappingRepository> findByNicknameContainingOrderByPointDesc(String nickname, Pageable pageable);
    Page<RankMappingRepository> findByOrderByPointDesc(Pageable pageable);
//    Optional<RankMappingRepository> findByNicknameOrderByPointDesc(String nickname);
}
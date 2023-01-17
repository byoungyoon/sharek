package co.kr.sharek.project.repository;

import co.kr.sharek.config.security.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Member, Long> {
    List<MemberInfoMappingRepository> findAllBy();
}
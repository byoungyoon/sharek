package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.config.security.repository.MemberRepository;
import co.kr.sharek.project.dto.RankResponseDto;
import co.kr.sharek.project.repository.RankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(RankService.class)
class RankServiceTest {

    @Autowired
    RankRepository rankRepository;
    @Autowired
    RankService rankService;

    @BeforeEach
    void data_set(){
        Member member = Member.builder()
                .point(10L)
                .state("as")
                .nickname("aff")
                .email("post@naver.com")
                .password("1234")
                .build();
        rankRepository.save(member);
    }

    @Test
    void findAllBy() {
        rankService.findAllBy();
    }
}
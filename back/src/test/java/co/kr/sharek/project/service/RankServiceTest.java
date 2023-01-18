package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.dto.RankRequestDto;
import co.kr.sharek.project.repository.RankRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(RankService.class)
class RankServiceTest {

    @Autowired
    RankRepository rankRepository;
    @Autowired
    RankService rankService;

    @BeforeEach
    void data_set(){
        final String nickname = "nick";
        final String state = "state";

        Member member = Member.builder()
                .point(10L)
                .nickname(nickname)
                .email("post@naver.com")
                .password("1234")
                .state(state)
                .build();
        rankRepository.save(member);
    }

    @AfterEach
    void clean_up() {
    rankRepository.deleteAll();
}

    @Test
    void findAllBy() {

        List<RankRequestDto> findRank = rankService.findAllBy();
        RankRequestDto m = findRank.get(0);

        System.out.println("State : " + m.getState());
        System.out.println("Point : " + m.getPoint());
        System.out.println("Id : " + m.getId());
        System.out.println("Nickname : " + m.getNickname());
        System.out.println("size : " + findRank.size());
        assertThat(m.getNickname()).isEqualTo("nick");
    }
}
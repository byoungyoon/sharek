package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.repository.RankMappingRepository;
import co.kr.sharek.project.repository.RankRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    void 전체랭킹출력() {
        Pageable pageable = PageRequest.of(0,20);
        Page<RankMappingRepository> page =  rankRepository.findByOrderByPointDesc(pageable);
        System.out.println("Page Size : " + page.getSize());
        System.out.println("Total Pages : " + page.getTotalPages());
        System.out.println("Total Count : " + page.getTotalElements());
        System.out.println("isNextPage : " + page.hasNext());
        System.out.println("Next : " + page.nextPageable());

        List<RankMappingRepository> list = page.getContent();
        list.forEach(System.out::println);
    }
}
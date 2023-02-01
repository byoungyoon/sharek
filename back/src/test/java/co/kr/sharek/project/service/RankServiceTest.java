package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.dto.RankResponseDto;
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                .point(40L)
                .nickname(nickname)
                .email("post@naver.com")
                .password("1234")
                .state(state)
                .build();

        rankRepository.save(member);

        Member member1 = Member.builder()
                .point(10L)
                .nickname("nickname2")
                .email("post2@naver.com")
                .password("1234")
                .state(state)
                .build();

        rankRepository.save(member1);

        Member member2 = Member.builder()
                .point(80L)
                .nickname("nickname3")
                .email("post3@naver.com")
                .password("1234")
                .state(state)
                .build();

        rankRepository.save(member2);
    }

    @AfterEach
    void clean_up() {
    rankRepository.deleteAll();
}

    @Test
    void 전체랭킹출력() {
        Pageable pageable = PageRequest.of(0,2);
        String nickname = "nickname4";

        Page<RankMappingRepository> page =  rankRepository.findByNicknameContainingOrderByPointDesc(nickname, pageable);

        if(page.isEmpty()){
            Page<RankMappingRepository> pages = rankRepository.findByOrderByPointDesc(pageable);
            System.out.println(pages.getContent());
            List<RankMappingRepository> l = pages.getContent();
            l.forEach(System.out::println);
        } else{
            System.out.println("Page Size : " + page.getSize());
            System.out.println("Total Pages : " + page.getTotalPages());
            System.out.println("Total Count : " + page.getTotalElements());
            System.out.println("isNextPage : " + page.hasNext());
            System.out.println("Next : " + page.nextPageable());

            List<RankMappingRepository> list = page.getContent();
            System.out.println(list.get(0));
        }
    }

//    @Test
//    void 내랭킹확인(){
//        List<RankMappingRepository> list = rankRepository.findByOrderByPointDesc();
//
//        System.out.println(list.stream()
//                .map(RankResponseDto::from)
//                .collect(Collectors.toList()));
//
//        for(int i=0; i<list.size(); i++){
//            if(list.get(i).getNickname().equals("nickname2")){
//                System.out.println(i+1 + "번째 있음");
//                break;
//            }
//        }
//
//    }
}
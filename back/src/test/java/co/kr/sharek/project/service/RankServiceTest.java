package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.repository.RankRepositoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(RankService.class)
class RankServiceTest {

    @Autowired
    RankRepositoryTest rankRepository;
    @Autowired
    RankService rankService;

    @BeforeEach
    void data_set(){
        final String nickname = "nick";
        final String state = "state";

        Member member = Member.builder()
                .password("1234")
                .nickname("name13477")
                .email("email@naver.com")
                .state(state)
                .point(40L)
                .build();

        Member member2 = Member.builder()
                .password("1234")
                .nickname("name134")
                .email("emai4l@naver.com")
                .state(state)
                .point(20L)
                .build();

        Member member3 = Member.builder()
                .password("1234")
                .nickname("name1342")
                .email("emai3l@naver.com")
                .state(state)
                .point(10L)
                .build();

        rankRepository.save(member);
        rankRepository.save(member2);
        rankRepository.save(member3);


    }

    @AfterEach
    void clean_up() {
        rankRepository.deleteAll();
}

    @Test
    void 전체랭킹출력() {
        Pageable pageable = PageRequest.of(0,3);

//        Page<RankMappingRepository> page =  rankRepository.findByNicknameContainingOrderByPointDesc(null, pageable);

//        Page<RankMappingRepository> page =  rankRepository.findByOrderByPointDesc(pageable);
//        Slice<RankSummary> list = rankRepository.findByOrderByPointDesc(PageRequest.of(0, 2));
//        Page<RankSummary> lists = rankRepository.findByNicknameContainingOrderByPointDesc("name", PageRequest.of(0, 3));
//        System.out.println(" ");
//        for (RankSummary r : lists.getContent()){
//            System.out.println(r.getPoint());
//        }
        System.out.println(" ");
//        if(page.isEmpty()){
//            Page<RankMappingRepository> pages = rankRepository.findByOrderByPointDesc(pageable);
//            System.out.println(pages.getContent());
//            List<RankMappingRepository> l = pages.getContent();
//            l.forEach(System.out::println);
//        } else{
//            System.out.println("Page Size : " + page.getSize());
//            System.out.println("Total Pages : " + page.getTotalPages());
//            System.out.println("Total Count : " + page.getTotalElements());
//            System.out.println("isNextPage : " + page.hasNext());
//            System.out.println("Next : " + page.nextPageable());
//
//            List<RankMappingRepository> list = page.getContent();
//            System.out.println(list.get(0));
//        }
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
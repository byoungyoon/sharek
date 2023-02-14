package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.repository.RankRepository;
import co.kr.sharek.project.repository.RankRepositoryTest;
import co.kr.sharek.project.repository.RankSummary;
import co.kr.sharek.project.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(RankService.class)
class RankServiceTest {

    @Autowired
    RankRepositoryTest rankRepositoryTest;
    RankRepository rankRepository;
    @Autowired
    RankService rankService;

    @Autowired
    UserRepository userRepository;

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

        rankRepositoryTest.save(member);
        rankRepositoryTest.save(member2);
        rankRepositoryTest.save(member3);
    }

    @AfterEach
    void clean_up() {
        rankRepositoryTest.deleteAll();
}

    @Test
    void 전체랭킹출력() {
        Pageable pageable = PageRequest.of(0,2);
//        Page<RankSummary> member = rankRepositoryTest.findByOrderByPointDesc(pageable);

//        Page<User> user = rankRepository.findByOrderByPointDesc(pageable);
//        System.out.println(member.getNumber());

//        List<Member> u = rankRepositoryTest.findAll();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String json = null;
//
//        try {
//            json = mapper.writeValueAsString(u);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(json);

//        Page<RankMappingRepository> page =  rankRepository.findByNicknameContainingOrderByPointDesc(null, pageable);

//        Page<RankMappingRepository> page =  rankRepository.findByOrderByPointDesc(pageable);
//        Slice<RankSummary> list = rankRepository.findByOrderByPointDesc(PageRequest.of(0, 2));
//        Page<RankSummary> lists = rankRepository.findByNicknameContainingOrderByPointDesc("name", PageRequest.of(0, 1));
//        System.out.println(lists.stream().count());
//        System.out.println(" ");
//        for (RankSummary r : lists.getContent()){
//            System.out.println(r.getPoint());
//        }
//        System.out.println(" ");
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
}
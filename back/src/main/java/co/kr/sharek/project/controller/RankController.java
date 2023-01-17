package co.kr.sharek.project.controller;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

//    @GetMapping("/test")
//    public ResponseEntity<List<Member>>findAllBy(){
//        return ResponseEntity.ok(rankService.findAllBy());
//    }
}

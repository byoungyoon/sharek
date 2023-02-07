package co.kr.sharek.project.controller;

import co.kr.sharek.project.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    @GetMapping("/rank/{nickname}")
    public ResponseEntity<?> findNickname(@PathVariable("nickname") String nickname, @PageableDefault(size=20) Pageable pageable){
        return ResponseEntity.ok(rankService.findNickname(nickname, pageable));
    }

    @GetMapping("/rank")
    public ResponseEntity<?> findAllRank(@PageableDefault(size=20) Pageable pageable){
        return ResponseEntity.ok(rankService.findAllRank(pageable));
    }

    @GetMapping("/myrank")
    public ResponseEntity<?> myRank(){
       return ResponseEntity.ok(rankService.findMyRank());
    }
}

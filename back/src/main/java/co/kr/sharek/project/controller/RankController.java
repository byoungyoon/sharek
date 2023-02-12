package co.kr.sharek.project.controller;

import co.kr.sharek.project.repository.RankRepository;
import co.kr.sharek.project.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Log4j2
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    @GetMapping("/api/rank/{nickname}")
    public ResponseEntity<?> getSearchNickname(@PathVariable(value="nickname") String nickname, @PageableDefault(size = 20) Pageable pageable){
        return ResponseEntity.ok(rankService.getSearchNickname(nickname, pageable));
    }

    @GetMapping("/api/rank")
    public ResponseEntity<?> getRankingList(@PageableDefault(size = 20) Pageable pageable){
        return ResponseEntity.ok(rankService.getRankingList(pageable));
    }

//    @GetMapping("/api/rank/{id}")
//    public ResponseEntity<?> myRank(){
//       return ResponseEntity.ok(rankService.findMyRank());
//    }
}

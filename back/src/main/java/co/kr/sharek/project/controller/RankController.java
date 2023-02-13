package co.kr.sharek.project.controller;

import co.kr.sharek.project.repository.RankRepository;
import co.kr.sharek.project.service.RankService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = { "사용자 랭킹 정보를 제공하는 RankController" })
@RestController
@Log4j2
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    @ApiResponse(code = 200, message = "성공")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "nickname", value="닉네임",  readOnly = true, dataType = "String", paramType = "path"),
        @ApiImplicitParam(name = "pageable", value="페이징",  readOnly = true, dataType = "Pageable", paramType = "query")
    })
    @Operation(summary = "사용자 랭킹 조회", description = "사용자 nickname을 기준으로 랭킹을 조회합니다.")
    @GetMapping("/api/rank/{nickname}")
    public ResponseEntity<?> getSearchNickname(@PathVariable(value="nickname") String nickname, @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(rankService.getSearchNickname(nickname, pageable));
    }

    @Operation(summary = "사용자 랭킹 페이징", description = "랭킹을 기존 20개씩 조회합니다.")
    @GetMapping("/api/rank")
    public ResponseEntity<?> getRankingList(
            @ApiParam(value = "페이징", defaultValue = "20")
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(rankService.getRankingList(pageable));
    }

//    @GetMapping("/api/rank/{id}")
//    public ResponseEntity<?> myRank(){
//       return ResponseEntity.ok(rankService.findMyRank());
//    }
}

package co.kr.sharek.project.controller;

import co.kr.sharek.common.constants.enums.ResCodeEnum;
import co.kr.sharek.common.dto.ResCodeDto;
import co.kr.sharek.common.util.JsonUtil;
import co.kr.sharek.project.dto.common.ReqPageDto;
import co.kr.sharek.project.dto.user.ReqRankDto;
import co.kr.sharek.project.service.RankService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(tags = { "사용자 랭킹 정보를 제공하는 RankController" })
@RestController
@Log4j2
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;
    private final JsonUtil jsonUtil;

    @ApiResponse(code = 200, message = "성공")
    @Operation(summary = "본인 랭킹 조회", description = "본인 id의 랭킹을 조회합니다.")
    @GetMapping("/api/myrank")
    public ResponseEntity<ResCodeDto> getUserRank(@Valid @ApiParam(value = "랭킹 dto") ReqRankDto reqRankDto) {
        jsonUtil.writeStringAndLog(reqRankDto);

        ResCodeDto resDto = ResCodeDto.builder()
                .code(ResCodeEnum.SUCCESS.getValue())
                .data(rankService.getUserRank(reqRankDto))
                .build();

        return ResponseEntity.ok(resDto);
    }

    @Operation(summary = "사용자 랭킹 페이징", description = "랭킹을 기존 20개씩 조회합니다.")
    @GetMapping("/api/rank")
    public ResponseEntity<ResCodeDto> getAllRank(@Valid @ApiParam(value = "페이지 dto") ReqPageDto reqDto) {
        jsonUtil.writeStringAndLog(reqDto);

        ResCodeDto resDto = ResCodeDto.builder()
                .code(ResCodeEnum.SUCCESS.getValue())
                .data(rankService.getRankAll(reqDto))
                .build();

        return ResponseEntity.ok(resDto);
    }
}

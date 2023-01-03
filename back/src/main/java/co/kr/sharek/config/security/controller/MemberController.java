package co.kr.sharek.config.security.controller;

import co.kr.sharek.config.security.dto.ChangePasswordRequestDto;
import co.kr.sharek.config.security.dto.MemberRequestDto;
import co.kr.sharek.config.security.dto.MemberResponseDto;
import co.kr.sharek.config.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {
  private final MemberService memberService;

  @GetMapping("/my-profile")
  public ResponseEntity<MemberResponseDto> getMyAccountInfo() {
    MemberResponseDto myInfo = memberService.getMyInfoBySecurity();
    log.info(myInfo.getNickname());
    return ResponseEntity.ok((myInfo));
  }

  @PostMapping("/nickname")
  public ResponseEntity<MemberResponseDto> setMemberNickname(@RequestBody MemberRequestDto request) {
    return ResponseEntity.ok(memberService.changeMemberNickname(request.getEmail(), request.getNickname()));
  }

  @PostMapping("/password")
  public ResponseEntity<MemberResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
    return ResponseEntity.ok(memberService.changeMemberPassword(request.getEmail(), request.getExpiredPassword(), request.getNewPassword()));
  }
}

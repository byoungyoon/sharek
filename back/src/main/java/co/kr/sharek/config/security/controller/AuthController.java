package co.kr.sharek.config.security.controller;

import co.kr.sharek.config.security.dto.MemberRequestDto;
import co.kr.sharek.config.security.dto.MemberResponseDto;
import co.kr.sharek.config.security.dto.TokenDto;
import co.kr.sharek.config.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
  private final AuthService authService;

  @PostMapping("/signup")
  public ResponseEntity<MemberResponseDto> signUp(@RequestBody MemberRequestDto requestDto) {
    log.info(requestDto.toString());
    return ResponseEntity.ok(authService.signUp(requestDto));
  }

  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
    log.info(requestDto.toString());
    return ResponseEntity.ok(authService.login(requestDto));
  }
}

package co.kr.sharek.config.security.service;

import co.kr.sharek.config.security.dto.MemberRequestDto;
import co.kr.sharek.config.security.dto.MemberResponseDto;
import co.kr.sharek.config.security.dto.TokenDto;
import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.config.security.jwt.JwtTokenProvider;
import co.kr.sharek.config.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthService {
  private final AuthenticationManagerBuilder managerBuilder;
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;

  public MemberResponseDto signUp(MemberRequestDto requestDto) {
    if (memberRepository.existsByEmail(requestDto.getEmail())) {
      throw new RuntimeException("이미 가입되어 있는 유저입니다");
    }

    Member member = requestDto.toMember(passwordEncoder);
    return MemberResponseDto.of(memberRepository.save(member));
  }

  public TokenDto login(MemberRequestDto requestDto) {
    UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

    Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

    return jwtTokenProvider.generateTokenDto(authentication);
  }
}

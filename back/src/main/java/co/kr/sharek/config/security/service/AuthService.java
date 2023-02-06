package co.kr.sharek.config.security.service;

import co.kr.sharek.config.security.dto.TokenDto;
import co.kr.sharek.config.security.jwt.JwtTokenProvider;
import co.kr.sharek.config.security.repository.MemberRepository;
import co.kr.sharek.project.dto.user.ReqLoginDto;
import co.kr.sharek.project.dto.user.ReqSignupDto;
import co.kr.sharek.project.dto.user.UserDto;
import co.kr.sharek.project.repository.UserRepository;
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

  private final UserRepository userRepository;

  public UserDto signUp(ReqSignupDto reqDto) {
    if (userRepository.existsById(reqDto.getId())) {
      throw new RuntimeException("이미 가입되어 있는 유저입니다");
    }

    UserDto userDto = UserDto.builder()
            .id(reqDto.getId())
            .pw(passwordEncoder.encode(reqDto.getPw()))
            .name(reqDto.getName())
            .nickname(reqDto.getNickname())
            .email(reqDto.getEmail())
            .build();

    userRepository.save(new UserDto().dtoByDomain(userDto));

    return userDto;
  }

  public TokenDto login(ReqLoginDto reqDto) {
    UsernamePasswordAuthenticationToken authenticationToken = reqDto.toAuthentication();

    Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

    return jwtTokenProvider.generateTokenDto(authentication);
  }
}

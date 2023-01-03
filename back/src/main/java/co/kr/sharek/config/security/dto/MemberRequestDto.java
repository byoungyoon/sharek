package co.kr.sharek.config.security.dto;

import co.kr.sharek.config.security.entity.Authority;
import co.kr.sharek.config.security.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
  private String email;
  private String password;
  private String nickname;

  public Member toMember(PasswordEncoder passwordEncoder) {
    return Member.builder()
        .email(email)
        .password(passwordEncoder.encode(password))
        .nickname(nickname)
        .authority(Authority.ROLE_USER)
        .build();
  }

  public UsernamePasswordAuthenticationToken toAuthentication() {
    return new UsernamePasswordAuthenticationToken(email, password);
  }
}

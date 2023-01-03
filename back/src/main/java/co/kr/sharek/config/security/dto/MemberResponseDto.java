package co.kr.sharek.config.security.dto;

import co.kr.sharek.config.security.entity.Member;
import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
  private String email;
  private String nickname;
  private String profile;

  public static MemberResponseDto of(Member member) {
    return MemberResponseDto.builder()
        .email(member.getEmail())
        .nickname(member.getNickname())
        .profile(member.getProfile())
        .build();
  }
}

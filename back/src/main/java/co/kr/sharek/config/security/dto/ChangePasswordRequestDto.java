package co.kr.sharek.config.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequestDto {
  private String email;
  private String expiredPassword;
  private String newPassword;
}

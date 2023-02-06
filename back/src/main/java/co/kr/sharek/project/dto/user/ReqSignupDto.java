package co.kr.sharek.project.dto.user;

import co.kr.sharek.common.validation.annotation.PatternCheck;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * signup request dto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqSignupDto {
    @NotNull
    @PatternCheck(regexp = "^[a-z]+[a-z0-9]{4,15}$")
    private String id;

    @NotNull
    @PatternCheck(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}$")
    private String pw;

    @NotNull
    @Length(max = 4)
    private String name;

    @NotNull
    @PatternCheck(regexp = "^[a-z]{0,6}$")
    private String nickname;

    @NotNull
    @PatternCheck(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$")
    private String email;
}

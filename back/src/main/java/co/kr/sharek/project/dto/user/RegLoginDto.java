package co.kr.sharek.project.dto.user;

import co.kr.sharek.common.validation.annotation.PatternCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * login request dto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegLoginDto {
    @NotNull
    @PatternCheck(regexp = "/^[a-z]+[a-z0-9]{5,15}$/g")
    private String id;

    @NotNull
    @PatternCheck(regexp = "/^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}$/")
    private String pw;
}

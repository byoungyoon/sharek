package co.kr.sharek.project.dto.user;

import co.kr.sharek.common.validation.annotation.PatternCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotNull;

/**
 * login request dto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqLoginDto {
    @NotNull
    @PatternCheck(regexp = "^[a-z]+[a-z0-9]{4,15}$")
    private String id;

    @NotNull
    @PatternCheck(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}$")
    private String pw;

    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(id, pw);
    }
}

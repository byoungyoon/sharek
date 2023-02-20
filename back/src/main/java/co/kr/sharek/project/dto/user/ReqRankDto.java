package co.kr.sharek.project.dto.user;

import co.kr.sharek.common.validation.annotation.PatternCheck;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReqRankDto {
    @PatternCheck(regexp = "^[a-z]+[a-z0-9]{4,15}$")
    private String id;

    private String name;

    private String nickname;

    private String img;

    private String profill;

    private Long point;
}

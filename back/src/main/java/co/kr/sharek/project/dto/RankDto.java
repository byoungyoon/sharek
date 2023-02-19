package co.kr.sharek.project.dto;

import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.repository.RankSummary;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RankDto {
    private String id;
    private String name;
    private String nickname;
    private String img;
    private String profile;
    private String team;
    private Long point;
    private Long rank;
}

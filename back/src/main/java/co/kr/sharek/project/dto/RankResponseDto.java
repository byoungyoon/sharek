package co.kr.sharek.project.dto;

import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.repository.RankSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RankResponseDto {
    private String id;
    private String name;
    private String nickname;
    private String img;
    private String profile;
    private String team;
    private Long point;

    public static RankResponseDto from(User user){
        return new RankResponseDto(
                user.getId(),
                user.getName(),
                user.getNickname(),
                user.getImg(),
                user.getProfill(),
                user.getTeam(),
                user.getPoint()
        );
    }
}

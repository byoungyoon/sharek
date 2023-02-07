package co.kr.sharek.project.dto;

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

    public static RankResponseDto from(RankSummary rank){
        return new RankResponseDto(
                rank.getId(),
                rank.getName(),
                rank.getNickname(),
                rank.getImg(),
                rank.getProfile(),
                rank.getTeam(),
                rank.getPoint()
        );
    }
}

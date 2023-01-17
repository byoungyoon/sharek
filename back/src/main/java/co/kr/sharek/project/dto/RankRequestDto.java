package co.kr.sharek.project.dto;

import co.kr.sharek.config.security.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RankRequestDto {
    private Long id;
    private String nickname;
    private String state;
    private Long point;

    public RankRequestDto(Long id, Long point, String nickname, String state) {
        this.id = id;
        this.point = point;
        this.state = state;
        this.nickname = nickname;
    }

    public static RankRequestDto from(Member member){
        return new RankRequestDto(
                member.getId(),
                member.getPoint(),
                member.getState(),
                member.getNickname()
        );
    }
}

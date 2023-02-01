package co.kr.sharek.project.dto;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.repository.RankMappingRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RankResponseDto {
    private Long id;
    private String nickname;
    private String state;
    private Long point;

    public RankResponseDto(String nickname) {
         this.nickname = nickname;
    }

    public RankResponseDto(String nickname, Long id, Long point, String state) {
        this.nickname = nickname;
        this.id = id;
        this.point = point;
        this.state = state;
    }

    public static RankResponseDto from(Member member){
        return new RankResponseDto(
            member.getNickname(),
            member.getId(),
            member.getPoint(),
            member.getState());
    }

    public static RankResponseDto from(String nickname){
        return new RankResponseDto(nickname);
    }

    public static RankResponseDto from(RankMappingRepository rank) {
        return new RankResponseDto(
                rank.getId(),
                rank.getNickname(),
                rank.getState(),
                rank.getPoint()
        );
    }
}

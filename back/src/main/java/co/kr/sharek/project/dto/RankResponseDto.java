package co.kr.sharek.project.dto;

import co.kr.sharek.project.repository.RankMappingRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RankResponseDto {
    private Long id;
    private String nickname;
    private String state;
    private Long point;

    public RankResponseDto(Long id, Long point, String nickname, String state) {
         this.id = id;
         this.point = point;
         this.state = state;
         this.nickname = nickname;
    }
}

package co.kr.sharek.project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rank;

    private String id;

    private String nickname;

    private Long point;

    private String state;

    @Builder
    public Rank(Long rank, String id, String nickname, Long point, String state) {
        this.rank = rank;
        this.id = id;
        this.nickname = nickname;
        this.point = point;
        this.state = state;
    }
}

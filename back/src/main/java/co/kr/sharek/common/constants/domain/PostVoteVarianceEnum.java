package co.kr.sharek.common.constants.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PostVoteVarianceEnum {
    UP(1),
    DOWN(-1);

    private int value;
}

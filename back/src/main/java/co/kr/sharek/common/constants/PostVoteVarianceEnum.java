package co.kr.sharek.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PostVote entity variance enum values
 */
@AllArgsConstructor
@Getter
public enum PostVoteVarianceEnum {
    UP(1),
    DOWN(-1);

    private int value;
}

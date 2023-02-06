package co.kr.sharek.common.constants.enums;

import co.kr.sharek.common.util.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * PostVote entity variance enum values
 */
@AllArgsConstructor
public enum PostVoteVarianceEnum implements IEnum<Integer> {
    UP(1),
    DOWN(-1);

    private int value;

    @Override
    public Integer getValue(){
        return value;
    }
}

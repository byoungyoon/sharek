package co.kr.sharek.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * User entity state enum values
 */
@Getter
@AllArgsConstructor
public enum UserStateEnum {
    ACTIVE("활성화"),
    TEMP("휴먼"),
    INACTIVE("정지");

    private String value;
}
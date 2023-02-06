package co.kr.sharek.common.constants.enums;

import co.kr.sharek.common.util.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * User entity state enum values
 */
@AllArgsConstructor
public enum UserStateEnum implements IEnum<String> {
    ACTIVE("활성화"),
    TEMP("휴먼"),
    INACTIVE("정지");

    private String value;

    @Override
    public String getValue(){
        return value;
    }
}
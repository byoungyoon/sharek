package co.kr.sharek.common.constants.enums;

import co.kr.sharek.common.util.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * Controller Response return code enum values
 */
@AllArgsConstructor
public enum ResCodeEnum implements IEnum<String> {
    SUCCESS("01"),
    FAILURE("02");

    private String value;

    @Override
    public String getValue(){
        return value;
    }
}

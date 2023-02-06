package co.kr.sharek.common.constants.enums;

import co.kr.sharek.common.util.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * User Entity auth enum values
 */
@AllArgsConstructor
public enum UserAuthEnum implements IEnum<String> {
    ROLE_ADMIN("관리자"),
    ROLE_USER("회원");

    private String value;

    @Override
    public String getValue(){
        return value;
    }
}

package co.kr.sharek.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * User Entity auth enum values
 */
@AllArgsConstructor
@Getter
public enum UserAuthEnum {
    ROLE_ADMIN("관리자"),
    ROLE_USER("회원");

    private String value;
}

package co.kr.sharek.common.util.enums;

import co.kr.sharek.common.constants.enums.UserStateEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

/**
 * UserStateEnum value 매칭
 */
@Converter
public class UserStateConverter implements AttributeConverter<UserStateEnum, String> {
    @Override
    public String convertToDatabaseColumn(UserStateEnum attribute) {
        return attribute.getValue();
    }

    @Override
    public UserStateEnum convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(UserStateEnum.class).stream()
                .filter(e -> e.getValue().equals(dbData))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}

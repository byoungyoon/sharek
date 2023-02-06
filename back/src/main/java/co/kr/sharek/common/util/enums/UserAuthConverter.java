package co.kr.sharek.common.util.enums;

import co.kr.sharek.common.constants.enums.UserAuthEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

/**
 * UserAuthEnum value 매칭
 */
@Converter
public class UserAuthConverter implements AttributeConverter<UserAuthEnum, String> {
    @Override
    public String convertToDatabaseColumn(UserAuthEnum attribute) {
        return attribute.getValue();
    }

    @Override
    public UserAuthEnum convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(UserAuthEnum.class).stream()
                .filter(e -> e.getValue().equals(dbData))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}

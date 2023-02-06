package co.kr.sharek.common.util.enums;

import co.kr.sharek.common.constants.enums.PostVoteVarianceEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

/**
 * PostVoteVarianceEnum value 매칭
 */
@Converter
public class PostVoteVarianceConverter implements AttributeConverter<PostVoteVarianceEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PostVoteVarianceEnum attribute) {
        return attribute.getValue();
    }

    @Override
    public PostVoteVarianceEnum convertToEntityAttribute(Integer dbData) {
        return EnumSet.allOf(PostVoteVarianceEnum.class).stream()
                .filter(e -> e.getValue().equals(dbData))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}

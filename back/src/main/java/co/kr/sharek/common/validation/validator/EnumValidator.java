package co.kr.sharek.common.validation.validator;


import co.kr.sharek.common.validation.annotation.EnumCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * EnumCheck action validator
 */
public class EnumValidator implements ConstraintValidator<EnumCheck, CharSequence> {
    private List<String> acceptedValues;

    @Override
    public void initialize(EnumCheck annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toString());
    }
}

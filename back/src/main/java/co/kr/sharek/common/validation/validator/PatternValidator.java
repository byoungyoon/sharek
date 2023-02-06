package co.kr.sharek.common.validation.validator;

import co.kr.sharek.common.validation.annotation.PatternCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * PatternCheck action validator
 */
public class PatternValidator implements ConstraintValidator<PatternCheck, String> {
    private Pattern pattern;

    @Override
    public void initialize(PatternCheck annotation){
        try {
            pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e){
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value == null) return true;

        Matcher m = pattern.matcher(value);
        return m.matches();
    }
}

package co.kr.sharek.common.validation.annotation;

import co.kr.sharek.common.validation.validator.PatternValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Pattern matching annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PatternValidator.class)
public @interface PatternCheck {
    String regexp();
    String message() default "must match \"{regexp}\"";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package co.kr.sharek.common.validation.annotation;

import co.kr.sharek.common.validation.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * enum check annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumCheck {
    Class<? extends Enum<?>> enumClass();
    String message() default "must be any of enum {enumClass}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

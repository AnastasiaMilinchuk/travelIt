package com.travelit.secure.validation.annotations;

import com.travelit.secure.validation.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by milinchuk on 4/27/15.
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidPlace {
    String message() default "Invalid place data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
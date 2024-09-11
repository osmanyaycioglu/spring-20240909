package org.turkcell.trainint.spring.springweb.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CheckWordsImpl.class,CheckWordsCustomerImpl.class})
public @interface CheckWords {

    String[] value();

    String message() default "{jakarta.validation.constraints.CheckWords.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

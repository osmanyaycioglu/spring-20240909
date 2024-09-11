package org.turkcell.trainint.spring.springweb.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckWordsImpl implements ConstraintValidator<CheckWords,String> {

    private CheckWords anno;

    @Override
    public void initialize(final CheckWords constraintAnnotation) {
        anno = constraintAnnotation;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        String[] valueLoc = anno.value();
        for (String sLoc : valueLoc) {
            if (value.contains(sLoc)){
                return false;
            }
        }
        return true;
    }
}

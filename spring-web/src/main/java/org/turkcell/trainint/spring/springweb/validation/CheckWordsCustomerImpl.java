package org.turkcell.trainint.spring.springweb.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.turkcell.trainint.spring.springweb.customer.rest.models.CustomerDto;

public class CheckWordsCustomerImpl implements ConstraintValidator<CheckWords, CustomerDto> {

    private CheckWords anno;

    @Override
    public void initialize(final CheckWords constraintAnnotation) {
        anno = constraintAnnotation;
    }

    @Override
    public boolean isValid(final CustomerDto value,
                           final ConstraintValidatorContext context) {
        String[] valueLoc = anno.value();
        for (String sLoc : valueLoc) {
            if (value.getUsername()
                     .contains(sLoc) || value.getPassword()
                                             .contains(sLoc) || value.getName()
                                                                     .contains(sLoc) || value.getSurname()
                                                                                             .contains(sLoc)) {
                return false;
            }
        }
        return true;
    }
}

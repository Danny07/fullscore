/**
 * 
 */
package com.co.dannykrd.fullscore.utils.validationPersonals;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (password == null) return false;

        boolean valid = true;
        context.disableDefaultConstraintViolation();

        if (!password.matches(".*[A-Z].*")) {
            context.buildConstraintViolationWithTemplate("{password.must.contain.uppercase}")
                   .addConstraintViolation();
            valid = false;
        }

        if (!password.matches(".*[a-z].*")) {
            context.buildConstraintViolationWithTemplate("{password.must.contain.lowercase}")
                   .addConstraintViolation();
            valid = false;
        }

        if (!password.matches(".*\\d.*")) {
            context.buildConstraintViolationWithTemplate("{password.must.contain.digit}")
                   .addConstraintViolation();
            valid = false;
        }

        if (!password.matches(".*[@$!%*?&._-].*")) {
            context.buildConstraintViolationWithTemplate("{password.must.contain.special}")
                   .addConstraintViolation();
            valid = false;
        }

        if (password.length() < 8) {
            context.buildConstraintViolationWithTemplate("{password.too.short}")
                   .addConstraintViolation();
            valid = false;
        }

        return valid;
	}

}

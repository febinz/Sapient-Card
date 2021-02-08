package com.sapient.creditcard.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Febin
 * ValidCardNumber annotation
 */

@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCardNumber {
	
	String message() default "Not a valid credit card number";
	 Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};

}

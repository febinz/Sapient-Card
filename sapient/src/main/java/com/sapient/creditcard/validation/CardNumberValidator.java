package com.sapient.creditcard.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<ValidCardNumber, Long> {

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return validateCardNumber(value);
	}
	
	/**
	 * Luhn 10 implementation
	 */
	public static boolean validateCardNumber(long ccNumber)
	{
		int sum = 0;
		boolean alternate = false;

		do {
			int n = (int) (ccNumber % 10);
			ccNumber = ccNumber / 10;
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		} while (ccNumber > 0);
		return (sum % 10 == 0);
	}
	
}

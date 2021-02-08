/**
 * 
 */
package com.sapient.creditcard.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.sapient.creditcard.validation.ValidCardNumber;

/**
 * @author Febin
 *
 */
@Entity
public class Card {
	 
	@Id
	@Positive(message = "Card number must be positive")
	@Digits(fraction = 0,integer = 19, message = "Card number length is greater than 19")
	@ValidCardNumber
	private Long cardNumber;
	
	@NotEmpty(message = "Name can't be empty")
	private String name;
	
	@Positive(message = "Limit must be greater than zero")
	private BigDecimal limit;
	
	@PositiveOrZero(message = "Balance must be positive")
	private BigDecimal balance = BigDecimal.ZERO;
	
	
	public Card() {

	}

	public Card(String name, Long cardNumber, BigDecimal limit) {

		super();
		
		this.name = name;
		this.cardNumber = cardNumber;
		this.limit = limit;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

}

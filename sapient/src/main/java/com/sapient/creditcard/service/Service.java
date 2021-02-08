/**
 * 
 */
package com.sapient.creditcard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.creditcard.model.Card;

/**
 * @author Febin
 *
 *Service layer class
 */

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private CardRepository repository;
	
	
	/**
	 * Returns all the cards in the system as a list
	 */
	public List<Card> getAllCards() {
		
		List<Card> cardList = new ArrayList<Card>();
		repository.findAll().forEach(cardList::add);
		return cardList;

	}
	

	/**
	 * Adding new card
	 */
	public Card addCard(Card model)
	{
		return repository.save(model);
	}
}

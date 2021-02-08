/**
 * 
 */
package com.sapient.creditcard.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.creditcard.model.Card;
import com.sapient.creditcard.service.Service;


/**
 * @author Febin
 *
 */
@RestController
@Validated
public class CardController {

	@Autowired
	private Service service;
	
	
	/**
	 * returning all cards
	 */
	@GetMapping("/cards")
	public List<Card> getAll() {
		
		return service.getAllCards();
		
	}
	
	
	/**
	 * adding new card
	 */
	
	@PostMapping("/cards")
	public ResponseEntity<Object> add(@Valid @RequestBody Card card) throws Exception {

		Card newCard = service.addCard(card);

		if (newCard == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCard.getCardNumber()).toUri();

		return ResponseEntity.created(location).build();

	}
}

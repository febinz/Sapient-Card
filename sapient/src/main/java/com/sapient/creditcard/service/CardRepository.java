/**
 * 
 */
package com.sapient.creditcard.service;

import org.springframework.data.repository.CrudRepository;

import com.sapient.creditcard.model.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

}

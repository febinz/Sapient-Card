package com.sapient.creditcard.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.creditcard.model.Card;
import com.sapient.creditcard.service.Service;

/**
 * @author Febin
 * Test class for card controller
 */

@WebMvcTest(CardController.class)
public class CardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Service service;
	
	Card card = new Card("Test",4003600000000014L,BigDecimal.TEN);
	
	 @Test 
		public void addTest() throws Exception {

			Mockito.when(service.addCard(Mockito.any(Card.class))).thenReturn(card);

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(card);

			MvcResult result = this.mockMvc
					.perform(post("/cards").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson))
					.andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		} 
	

	@Test
	public void getAllTest() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/cards")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}


}

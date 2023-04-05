package org.capgemini.proyecto2.controller;

import org.capgemini.proyecto2.model.Card;
import org.capgemini.proyecto2.response.PaymentResponse;
import org.capgemini.proyecto2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/api/v1/payments")
@Tag(name = "payments", description = "Payments API")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping
	public ResponseEntity<PaymentResponse> payTicket(@RequestBody Card card) {
		
		PaymentResponse result = paymentService.payTicket(card);
		
		if(result == null) {
			return ResponseEntity.notFound().build();			
		}
		
		return ResponseEntity.ok(result);
	}

}

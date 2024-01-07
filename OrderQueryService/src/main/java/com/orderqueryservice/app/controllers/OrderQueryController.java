package com.orderqueryservice.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ordercommandservice.app.entities.OrderEntity;
import com.orderqueryservice.app.services.OrderQueryService;

@RestController
public class OrderQueryController {
	
	@Autowired
	OrderQueryService oqs;
	@GetMapping("/get-order-data/{id}")
	public ResponseEntity<OrderEntity> getOrder(@PathVariable int id){
		System.out.println("ID ==>" +id);
		return oqs.findOrderById(id);
	}
	

}

package com.ordercommandservice.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordercommandservice.app.entities.OrderEntity;
import com.ordercommandservice.app.services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService os;

	@PostMapping("/save-order")
	public ResponseEntity<OrderEntity> saveOrder(@RequestBody OrderEntity order){
		return os.saveOrder(order);
	}
	
	@PutMapping("/update-order/{id}")
	public ResponseEntity<OrderEntity> updateOrder(@RequestBody OrderEntity order, @PathVariable long id){
		System.out.println("Controller: "+order.toString()+", ID => "+id);
		return os.updateOrder(order,id);
	}
	
}

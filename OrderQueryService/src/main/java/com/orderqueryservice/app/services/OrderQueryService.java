package com.orderqueryservice.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ordercommandservice.app.entities.OrderEntity;
import com.orderqueryservice.app.repos.OrderQueryRepo;

@Service
public class OrderQueryService {

	@Autowired
	OrderQueryRepo oqr;
	
	public ResponseEntity<OrderEntity> findOrderById(long id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<OrderEntity>(oqr.findById(id).get(),HttpStatus.OK);
	}
	
	@KafkaListener(topics = "order-topic", groupId = "my-group-id")
	public void listen(OrderEntity message) {
		System.out.println("Received message:---> " + message.toString());
		Optional<OrderEntity> op = oqr.findById(message.getId());
		OrderEntity oe =null;
		if(op.isPresent()) {
			//update operation
			System.out.println("Updating record !!! ");
			oe = op.get();
			oe.setId(message.getId());
			oe.setFood(message.getFood());
			oe.setName(message.getName());
			oe.setPrice(message.getPrice());
			oe.setQty(message.getQty());
			oe.setTotal(message.getTotal());
		}else {
			//create operation
			System.out.println("Creating new record !!!");
			oe = message;
		}
		oqr.save(oe);
		System.out.println("Record saved.");
	}


}

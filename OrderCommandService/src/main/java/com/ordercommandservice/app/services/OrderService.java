package com.ordercommandservice.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ordercommandservice.app.entities.OrderEntity;
import com.ordercommandservice.app.repos.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo or;
	
	@Autowired
	KafkaTemplate<String, OrderEntity> kafka;

	public ResponseEntity<OrderEntity> saveOrder(OrderEntity order) {
		order.setTotal(order.getPrice() * order.getQty());
		or.save(order);
		kafka.send("order-topic", "key", order);
		return new ResponseEntity(order, HttpStatus.OK);
	}

	public ResponseEntity<OrderEntity> updateOrder(OrderEntity order, long id) {
		System.out.println("Service: "+order.toString()+", ID => "+id);
		Optional<OrderEntity> op = or.findById(id);
		OrderEntity od = op.get();
		if(od != null) {
		od.setId(id);
		od.setFood(order.getFood());
		od.setName(order.getName());
		od.setPrice(order.getPrice());
		od.setQty(order.getQty());
		od.setTotal(order.getPrice() * order.getQty());
		System.out.println("Before Saving: "+od.toString()+", ID => "+od.getId());
		or.save(od);
		kafka.send("order-topic", "key", od);
		System.out.println("Order updated!!!");
		}else {
			System.out.println("Order is null");
		}
		
		
		return new ResponseEntity<OrderEntity>(op.get(), HttpStatus.OK);
	}

}

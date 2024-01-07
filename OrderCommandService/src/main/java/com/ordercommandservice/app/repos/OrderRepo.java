package com.ordercommandservice.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordercommandservice.app.entities.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

}

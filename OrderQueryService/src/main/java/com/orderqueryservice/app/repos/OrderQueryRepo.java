package com.orderqueryservice.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordercommandservice.app.entities.OrderEntity;

public interface OrderQueryRepo extends JpaRepository<OrderEntity, Long> {

}

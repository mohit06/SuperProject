package com.ordercommandservice.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String name; // customer name
	String food; // order items
	int qty;
	float price;
	float total;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public OrderEntity(long id, String name, String food, int qty, float price) {
		super();
		this.id = id;
		this.name = name;
		this.food = food;
		this.qty = qty;
		this.price = price;
		this.total = qty * price;
	}

	public OrderEntity() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", food=" + food + ", qty=" + qty + ", total=" + total + "]";
	}

	public OrderEntity copy(OrderEntity order) {
		this.name = order.getName();
		this.price= order.getPrice();
		this.food=order.getFood();
		this.qty=order.getQty();
		this.total=qty*price;
		return this;
	}

}

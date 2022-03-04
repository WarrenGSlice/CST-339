package com.gcu.model;

import org.springframework.data.annotation.Id;

public class OrderModel {

	// Variables
	@Id
	public String id = "";
	public String orderNo = "";
	public String productName = "";
	public float price = 0;
	public int quantity = 0;

	// Create some Orders
//	public String getId() {
//		return id;
//	}

	public void setId(String id) {
		this.id = id;
	}

//	public String getOrderNo() {
//		return orderNo;
//	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

//	public String getProductName() {
//		return productName;
//	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

//	public float getPrice() {
//		return price;
//	}

	public void setPrice(float price) {
		this.price = price;
	}

//	public int getQuantity() {
//		return quantity;
//	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderModel(String id, String orderNo, String productName, float price, int quantity) {
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderModel() {
		this.id = "";
		this.orderNo = "";
		this.productName = "";
		this.price = 0;
		this.quantity = 0;
	}




}

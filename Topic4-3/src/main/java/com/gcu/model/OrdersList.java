package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.gcu.entity.OrderEntity;

@XmlRootElement(name="orders")
public class OrdersList {

	private List<OrderEntity> orders = new ArrayList<>();

	@XmlElement(name="order")
	public List<OrderEntity> getOrders()
	{
		return this.orders;
	}

	public void setOrders(List<OrderEntity> list)
	{
		this.orders = list;
	}
}
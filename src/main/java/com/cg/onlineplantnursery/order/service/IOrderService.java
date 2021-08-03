package com.cg.onlineplantnursery.order.service;

import java.util.List;

import com.cg.onlineplantnursery.order.entity.Orders;

public interface IOrderService {
	Orders addOrder(Orders order);
	
	Orders updateOrder(Orders order);
	
	void deleteOrder(Integer orderId);
	
	Orders viewOrder(Integer orderId);
	
	List<Orders> viewAllOrders();
}

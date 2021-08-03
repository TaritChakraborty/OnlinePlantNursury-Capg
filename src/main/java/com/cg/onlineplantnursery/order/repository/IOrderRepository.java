package com.cg.onlineplantnursery.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlineplantnursery.order.entity.Orders;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Integer>{
	public Orders findById(int orderId);
}

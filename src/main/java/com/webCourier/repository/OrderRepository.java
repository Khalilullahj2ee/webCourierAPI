package com.webCourier.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.webCourier.model.OrderTableModel;
import com.webCourier.model.UserModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderTableModel, Long> {

	@Query("select o From OrderTableModel o where o.trackingNum = ?1")
	
	List<OrderTableModel> findByTrackingNumber(String trackingNum);}
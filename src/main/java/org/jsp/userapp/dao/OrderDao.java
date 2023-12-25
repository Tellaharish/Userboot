package org.jsp.userapp.dao;

import java.util.Optional;

import org.jsp.userapp.dto.Order;
import org.jsp.userapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	@Autowired
	private OrderRepository repository;
	
	public Order save(Order order) {
		return repository.save(order);
	}
	public Order update(Order order) {
		return repository.save(order);
	}
	public Optional<Order> findbyid(int id) {
		return repository.findById(id);
	}
	public boolean delete(int id) {
		Optional<Order> recProduct = repository.findById(id);
		if(recProduct.isPresent()) {
			repository.delete(recProduct.get());
			return true;
		}
		return false;
		
	}
	

}

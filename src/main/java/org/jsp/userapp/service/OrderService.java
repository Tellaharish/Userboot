package org.jsp.userapp.service;

import java.util.Optional;

import org.jsp.userapp.dao.OrderDao;
import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.Order;
import org.jsp.userapp.dto.ResponseStructure;
import org.jsp.userapp.dto.ResponseStructure;
import org.jsp.userapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
	@Autowired
	private OrderDao odao;
	@Autowired
	private UserDao udao;
	
	public void save(Order order, int user_id) {
		Optional<User> recuser=udao.findbyId(user_id);
		ResponseStructure<Order> structure=new ResponseStructure<>();
		if(recuser.isPresent()) {
			User u=recuser.get();
			u.getOrders().add(order);
			order.setUsers(u);
			udao.updateuser(u);
			odao.save(order);
			structure.setData(order);
			structure.setMessage(null);

		}
		
	}

}

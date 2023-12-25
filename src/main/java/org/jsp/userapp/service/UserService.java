package org.jsp.userapp.service;

import java.util.Optional;

import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.ResponseStructure;
import org.jsp.userapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao udao;

	public ResponseEntity<ResponseStructure<User>> saveuser(User user) {
		User u = udao.saveuser(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(u);
		structure.setMessage("User saved with ID " + u.getId());
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> updateuser(User user) {
		User u = udao.saveuser(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(u);
		structure.setMessage("User Updated with ID " + u.getId());
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);

	}

	public ResponseEntity<ResponseStructure<User>> findbyid(int id) {
		Optional<User> recuser = udao.findbyId(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recuser.isPresent()) {
			structure.setData(recuser.get());
			structure.setMessage("User Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<String>> deletebyid(int id) {
		Optional<User> recuser = udao.findbyId(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recuser.isPresent()) {
			udao.deletebyid(id);
			structure.setData("User Deleted");
			structure.setMessage("User Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			
		}
		return null;
		
	}

}

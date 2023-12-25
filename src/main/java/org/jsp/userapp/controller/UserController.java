package org.jsp.userapp.controller;

import org.jsp.userapp.dto.ResponseStructure;
import org.jsp.userapp.dto.User;
import org.jsp.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> save(@RequestBody User u){
		return service.saveuser(u);
	}
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> update(@RequestBody User u){
		return service.updateuser(u);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findbyid(@PathVariable int id){
		return service.findbyid(id);
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteid(@PathVariable int id){
		return service.deletebyid(id);
	}
}

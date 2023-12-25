package org.jsp.userapp.dao;

import java.util.List;
import java.util.List;
import java.util.Optional;

import org.jsp.userapp.dto.User;
import org.jsp.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User saveuser(User user) {
		return repository.save(user);
	}

	public User updateuser(User user) {
		return repository.save(user);
	}

	public Optional<User> findbyId(int id) {
		return repository.findById(id);
	}

	public void deletebyid(int id) {
		repository.deleteById(id);
	}

	public List<User> findall() {
		return repository.findAll();

	}
	
	public Optional<User> verifybyemailpassword(String email,String password){
		return repository.verifybyemailandpassword(email, password);
	}
	public Optional<User> verifybyphonepassword(long phone,String password){
		return repository.verifybyphoneandpassword(phone, password);
	}

}

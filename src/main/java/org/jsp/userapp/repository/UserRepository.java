package org.jsp.userapp.repository;

import java.util.Optional;

import org.jsp.userapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.email=?1 and u.password=?2")
	Optional<User> verifybyemailandpassword(String email, String password);
	
	@Query("select u from User u where u.phone=?1 and u.password=?2")
	Optional<User> verifybyphoneandpassword(long phone, String password);

}

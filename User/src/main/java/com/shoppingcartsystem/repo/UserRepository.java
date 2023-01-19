package com.shoppingcartsystem.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByuEmail(String uEmail);
	User findByuEmail(String uEmail);
	
	User findByuId(long uId);
	
}

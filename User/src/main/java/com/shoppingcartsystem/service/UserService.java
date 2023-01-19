package com.shoppingcartsystem.service;

import java.util.List;


import com.shoppingcartsystem.model.User;


public interface UserService {

	List<User> findAll();
	
	User findByuId(Long uId);
	
	User addUser(User user);
	
	User updateUserByuId(User user);
	
	void deleteUserByuId(Long uId);
	
//	Role saveRole(Role rName);
//	
//	void addRoleToUser(String uEmail , String roleName);


	
//	User registerNewUser(User user);
	

}

package com.shoppingcartsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shoppingcartsystem.model.User;
import com.shoppingcartsystem.repo.UserRepository;
import com.shoppingcartsystem.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> findAll() {
		log.info("GETTING ALL USERS FROM DATABASE");
		return userRepository.findAll();
	}

	@Override
	public User findByuId(Long uId) {
		log.info("FETCHING USER BY UID", uId, "FROM DATABASE");
		return userRepository.findByuId(uId);
	}
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		log.info("SAVING USER FROM SERVICEIMPL", user);
		return userRepository.save(user);
	}

//	@Override
//	public User registerNewUser(User user) {
//		log.info("SAVING USER", user);
//		return userRepository.save(user);
//	}

	@Override
	public User updateUserByuId(User user) {
		log.info("UPDATING USER BY UID", user.getuId());
		return userRepository.save(user);
	}

	@Override
	public void deleteUserByuId(Long uId) {
		log.info("DELETING USER BY UID", uId, "FROM DATABASE");
		userRepository.deleteById(uId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User foundedUser = userRepository.findByuEmail(username);

		if (foundedUser == null)
			return null;
		String uEmail = foundedUser.getuEmail();
		String uPassword = new BCryptPasswordEncoder().encode(foundedUser.getuPassword());
		return new org.springframework.security.core.userdetails.User(uEmail, uPassword, new ArrayList<>());
	}

	

	

	
}

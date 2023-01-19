package com.shoppingcartsystem.controller;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartsystem.model.User;
import com.shoppingcartsystem.repo.UserRepository;
import com.shoppingcartsystem.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/allusers")
	private ResponseEntity<Object> getAllusers() {

		List<User> userLists = userService.findAll();
		if (!userLists.isEmpty()) {
			log.info("FINDING ALLUSERS INFO {}");
			return new ResponseEntity<Object>(userLists, HttpStatus.FOUND);
		} else {
			log.error("TRY AGAIN IN SOMETIME!!!");
			return new ResponseEntity<Object>("OPPS!!! SOMETHING WENT WRONG", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/user/{uId}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	private ResponseEntity<Object> getUserByuId(@PathVariable long uId) {

//		boolean isUserExists = userRepository.existsById(uId);
//		if(isUserExists) {
//			User user = userService.findByuId(uId);
//			log.info("GETTING USERBYUID!!!");
//			return new ResponseEntity<Object>(user,HttpStatus.FOUND);
//			
//			}else {
//				return new ResponseEntity<Object>("USER NOT PRESENT WITH THIS ID {}",HttpStatus.NOT_FOUND);
//			}

		User user = userService.findByuId(uId);
		if (user != null) {
			log.info("GETTING USERBYUID!!! " + uId);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} else {
			log.error("USER NOT PRESENT WITH THIS ID {} " + uId);
			return new ResponseEntity<Object>("USER NOT PRESENT WITH THIS ID {} " + uId, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/user/addUser")
	private ResponseEntity<Object> addUser(@RequestBody User user) {

//		if(user != null) {
//			try {
//				User addedUser = userService.addUser(user);
//				log.info("ADDING USER!!!");
//				return new ResponseEntity<Object>(addedUser,HttpStatus.CREATED);
//			}catch(Exception e) {
//				log.error("USER ALREADY PRESENT WITH THIS EMAIL ID");
//				return new ResponseEntity<Object>("USER ALREADY PRESENT WITH THIS EMAIL ID",HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

		boolean isUserExists = userRepository.existsByuEmail(user.getuEmail());
		if (!isUserExists) {
			userService.addUser(user);
			log.info("ADDING USER FROM CONTROLLER!!!");
			return new ResponseEntity<Object>(user.getuEmail(), HttpStatus.OK);
		} else {
			if (user.getuEmail() == null) {
				log.error("BAD REQUEST!!!");
				return new ResponseEntity<Object>("BAD REQUEST!!!", HttpStatus.BAD_REQUEST);
			} else {
				log.error("USER ALREADY PRESENT WITH THIS EMAIL ID");
				return new ResponseEntity<Object>("USER ALREADY PRESENT WITH THIS EMAIL ID",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}

	@PostMapping("/user/auth")
	private ResponseEntity<Object> authCustomer(@RequestBody User user) {
		String email = user.getuEmail();
		String password = user.getuPassword();
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			log.info("USER LOGGED IN!!!");
			return new ResponseEntity<Object>(user.getuEmail(), HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			log.error("LOGIN FAILED!!!");
			return new ResponseEntity<Object>("LOGIN FAILED", HttpStatus.BAD_REQUEST);

		}
	}



	@PutMapping("/update/{uId}")
	private ResponseEntity<Object> updateUserByuId(@RequestBody User user, @PathVariable long uId) {
		try {
			boolean isUserExistsByuId = userRepository.existsById(uId);
			if (isUserExistsByuId) {
				if (user.getuId() == uId) {
					userService.updateUserByuId(user);
					log.info("UPDATING USER BY ID {}");
					return new ResponseEntity<Object>(user, HttpStatus.OK);
				} else {
					log.error("UID MISMATCH {} ");
					return new ResponseEntity<Object>("UID MISMATCH {}", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.error("USER NOT FOUND WITH THIS ID {} " + uId);
				return new ResponseEntity<Object>("USER NOT FOUND WITH THIS ID {} " + uId, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("UID MISSING {} ");
			return new ResponseEntity<Object>("UID MISSING {}" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{uId}")
	private ResponseEntity<Object> deleteUserByuId(@PathVariable long uId) {

		boolean isUserExistsByuId = userRepository.existsById(uId);
		if (isUserExistsByuId) {
			userService.deleteUserByuId(uId);
			log.info("DELETING USER BY UID {}");
			return new ResponseEntity<Object>("USER DELETED WITH THIS UID {} " + uId, HttpStatus.OK);
		} else {
			log.error("USER NOT FOUND WITH THIS UID {} " + uId);
			return new ResponseEntity<Object>("USER NOT FOUND WITH THIS UID {} " + uId, HttpStatus.NOT_FOUND);
		}
	}

}

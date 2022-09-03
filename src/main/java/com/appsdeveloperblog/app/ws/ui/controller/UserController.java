package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;
import com.appsdeveloperblog.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("/users") // http://localhost8080/users
public class UserController {

	Map<String, UserRest> users;
	
	@Autowired
	UserService userService; 

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get users was called with page =" + page + "and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = {
			// MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
	if(true) throw new UserServiceException("A user serviceexception is thrrown");
		
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(// path = "/{userId}",
			consumes = {
					// MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }, produces = {
							// MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail(userDetails.getEmail());
//		returnValue.setFirstName(userDetails.getFirstName());
//		returnValue.setLastName(userDetails.getLastName());
//
//		String userId = UUID.randomUUID().toString();
//		returnValue.setUserId(userId);
//
//		if (users == null)
//			users = new HashMap<>();
//		users.put(userId, returnValue);

		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = {
			// MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = {
					// MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest stroredUserDetails = users.get(userId);
		stroredUserDetails.setFirstName(userDetails.getFirstName());
		stroredUserDetails.setLastName(userDetails.getLastName());

		users.put(userId, stroredUserDetails);

		return stroredUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

}

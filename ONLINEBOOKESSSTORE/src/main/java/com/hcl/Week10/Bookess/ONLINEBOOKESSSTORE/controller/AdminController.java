package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService.AdminService;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User users) {

		System.out.println("User is added");
		String result = adminService.addUser(users);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) throws Exception {
		try {

			System.out.println("login created ");
			System.out.println(user);
			int result = adminService.login(user);
			System.out.println(result);
			if (result == 1) {
				System.out.println("login Success ");
				// userService.addUsername(user.getUserName());
				ResponseEntity<String> result1 = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				return result1;

			}
		} catch (Exception exception) {
			System.out.println("login falied ");
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}
		return null;

	}

}

package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService.BookService;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService.UserService;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.LikeSection;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.ReadLater;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;

	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User users) {

		System.out.println("User is added");
		String result = userService.addUser(users);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) throws Exception {
		

			System.out.println("login created ");
			System.out.println(user);
			int result = userService.login(user);
			System.out.println(result);
			if (result == 1) {
				System.out.println("login Success ");
				// userService.addUsername(user.getUserName());
				User user1 = new User();
				user1.setValid("valid");
				ResponseEntity<User> result1 = new ResponseEntity<User>(user1, HttpStatus.OK);
				return result1;

			}
		
			
			else {
				User user1 = new User();
				user1.setValid("invalid");
				ResponseEntity<User> result1 = new ResponseEntity<User>(user1, HttpStatus.OK);
				return result1;

			}
		

	}

	@GetMapping("/userList")
	public ResponseEntity<List<User>> getUserList() throws Exception {
		try {

			System.out.println("login 2 created ");
			System.out.println();
			List<User> result = userService.getUsers();
			System.out.println(result);
			if (result != null) {
				System.out.println("Added successfully ");
				System.out.println(result);
				ResponseEntity<List<User>> result1 = new ResponseEntity<List<User>>(result, HttpStatus.OK);
				return result1;

			}
		} catch (Exception exception) {
			System.out.println("Adding user falied " + exception.getMessage());
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}
		return null;
	}

	
	//add the userId json data in postMan while editing the book
	@PostMapping("/editUser")
	public ResponseEntity<String> editUser(@RequestBody User users) throws Exception {

		System.out.println("User is added");
		String result = userService.editUser(users);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@DeleteMapping("/deleteUser/{userName}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userName") String userName) {

		System.out.println("User is added");
		String result = userService.deleteUser(userName);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@GetMapping("/sortByNames")
	public List<User> getUsersByName() {
		return userService.findAllOrderByNameAsc();
	}

	@PostMapping("/addReadLater")
	public ResponseEntity<String> addReadLaterBook(@RequestBody ReadLater readLater) {

		System.out.println("User is added");
		String result = userService.addReadLater(readLater);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@PostMapping("/addLikeSection")
	public ResponseEntity<String> addToLikdeSection(@RequestBody LikeSection likeSection) {

		System.out.println("User is added");
		String result = userService.addLikeSection(likeSection);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@GetMapping("/viewReadLaterType/{userId}")
	public ResponseEntity<List<ReadLater>> getReadLater(@PathVariable int userId) {

		System.out.println(userId + " vjevnioevneiu controller");
		List<ReadLater> readLater = userService.getReadLaterType(userId);
		ResponseEntity<List<ReadLater>> result1 = new ResponseEntity<List<ReadLater>>(readLater, HttpStatus.OK);
		return result1;

	}

	@GetMapping("/viewLikeSectionType/{userId}")
	public ResponseEntity<List<LikeSection>> getLikeSection(@PathVariable int userId) {

		System.out.println(userId + " controller");
		List<LikeSection> likeSection = userService.getLikeSection(userId);
		ResponseEntity<List<LikeSection>> result1 = new ResponseEntity<List<LikeSection>>(likeSection, HttpStatus.OK);
		return result1;

	}
	

	@GetMapping("/bookList")
	public ResponseEntity<List<Book>> getBookList() throws Exception {
		try {

			System.out.println("login 2 created ");
			System.out.println();
			List<Book> result = bookService.getBooks();
			System.out.println(result);
			if (result != null) {
				System.out.println("Added successfully ");
				System.out.println(result);
				ResponseEntity<List<Book>> result1 = new ResponseEntity<List<Book>>(result, HttpStatus.OK);
				return result1;

			}
		} catch (Exception exception) {
			System.out.println("Adding user falied " + exception.getMessage());
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}
		return null;
	}

}

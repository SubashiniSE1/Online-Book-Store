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
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class BooksController {

	@Autowired 
	BookService bookService;

	@PostMapping("/addBookPage")
	public ResponseEntity<String> addBooks(@RequestBody Book book) throws Exception {
		try {

			System.out.println("login 2 created ");
			System.out.println(book);
			int result = bookService.addBooks(book);
			System.out.println(result);
			if (result == 1) {
				System.out.println("Added successfully ");
				ResponseEntity<String> result1 = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				return result1;

			} else {
				System.out.println("Added successfully ");
				ResponseEntity<String> result1 = new ResponseEntity<String>("Book Is  Already in Your List",
						HttpStatus.BAD_REQUEST);
				return result1;

			}
		} catch (Exception exception) {
			System.out.println("Addimg booksfalied " + exception.getMessage());
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}

	}
	
     //add the bookId json data in postMan while editing the book
	@PostMapping("/editBook")
	public ResponseEntity<String> editUser(@RequestBody Book book) throws Exception {

		System.out.println("book is added");
		String result = bookService.editBooks(book);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "bookId") int bookId) {

		System.out.println("User is added");
		String result = bookService.deleteBook(bookId);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

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

	@GetMapping("/sortByBookNames")
	public List<Book> getBooksByBookName() {
		return bookService.findAllOrderByNameAsc();
	}
}

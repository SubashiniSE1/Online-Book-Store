package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO.BookDAO;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService.BookService;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;

public class BookTestCases {
	@InjectMocks
	BookService bookService;
	
	@Mock
	BookDAO bookDao;
	
//	@BeforeAll
//	public void init() {
//		MockitoAnnotations.openMocks(this);
//		
//	}
	@Test
	public void addBook() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book book = new Book();
		book.setBookId(1);
		book.setBookAuthor("Suba");
		book.setBookName("aa");
		book.setGenere("aa");
		book.setNoOfPages(566);
		
		bookList.add(book);
		when(bookDao.addBook(book)).thenReturn(bookList);
		assertEquals(bookList, bookService.addBook(book));
		bookList = verify(bookDao,times(1)).addBook(book);
	}

}

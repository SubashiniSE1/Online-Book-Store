package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService;

import java.util.ArrayList;
import java.util.List;


import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;

public interface BookService {

	public int addBooks(Book book);

	public String editBooks(Book book);

	public String deleteBook(int bookId);

	public List<Book> getBooks();

	public List<Book> findAllOrderByNameAsc();
	
	public ArrayList<Book> addBook(Book book);

}

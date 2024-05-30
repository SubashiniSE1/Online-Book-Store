package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO;

import java.util.ArrayList;
import java.util.List;


import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;

public interface BookDAO {

	public int addBooks(Book book);

	public int editBooks(Book book);

	public int deleteBook(int bookId);

	public List<Book> getBooks();

	public List<Book> findAllOrderByBookNameAsc();


	public ArrayList<Book> addBook(Book book);

}

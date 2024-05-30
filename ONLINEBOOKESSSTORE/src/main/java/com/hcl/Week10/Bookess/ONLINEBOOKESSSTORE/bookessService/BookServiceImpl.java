package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO.BookDAO;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDao;

	@Override
	public int addBooks(Book book) {
		System.out.println("service add book created ");
		return bookDao.addBooks(book);

	}

	@Override
	public String editBooks(Book book) {
		System.out.println("serviceedit books created ");

		bookDao.editBooks(book);
		return null;

	}

	@Override
	public String deleteBook(int bookId) {
		System.out.println("service delete food created ");
		int resp = bookDao.deleteBook(bookId);
		return null;

	}

	@Override
	public List<Book> getBooks() {
		List<Book> bookList = bookDao.getBooks();
		return bookList;

	}

	@Override
	public List<Book> findAllOrderByNameAsc() {
		return bookDao.findAllOrderByBookNameAsc();
	}

	@Override
	public ArrayList<Book> addBook(Book book) {
		
		return bookDao.addBook(book);
	}

}

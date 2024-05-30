package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity.BookEntity;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	ArrayList<Book> books = new ArrayList<Book>();

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addBooks(Book book) {

		System.out.println("dao food ietm created ");

		BookEntity bookEntity = new BookEntity();

		bookEntity.setBookId(book.getBookId());
		bookEntity.setBookName(book.getBookName());
		bookEntity.setBookAuthor(book.getBookAuthor());
		bookEntity.setGenere(book.getGenere());
		bookEntity.setNoOfPages(book.getNoOfPages());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setImage(book.getImage());
		System.out.println("value setter");
		entityManager.persist(bookEntity);
		System.out.println("value persisted ");

		return 1;
	}

	@Override
	public int editBooks(Book books) {
		String query = "update  BookEntity set bookAuthor=?1 ,price=?2,noOfPages=?3,genere=?4,bookName=?5 where bookId=?6";

		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, books.getBookAuthor());
		query1.setParameter(2, books.getPrice());
		query1.setParameter(3, books.getNoOfPages());
		query1.setParameter(4, books.getGenere());
		query1.setParameter(5, books.getBookName());
		query1.setParameter(6, books.getBookId());
		return query1.executeUpdate();

	}

	@Override
	public int deleteBook(int bookId) {

		String query = "delete from BookEntity where bookId=?1";

		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, bookId);
		return query1.executeUpdate();
	}

	@Override
	public List<Book> getBooks() {

		String query = "select b from BookEntity b";
		List<Book> booklist = new ArrayList<Book>();
		Query query1 = entityManager.createQuery(query);
		List<BookEntity> BookEntityList = query1.getResultList();
		for (BookEntity bookent : BookEntityList) {
			Book book = new Book();
			book.setBookId(bookent.getBookId());
			book.setBookName(bookent.getBookName());
			book.setBookAuthor(bookent.getBookAuthor());
			book.setPrice(bookent.getPrice());
			book.setNoOfPages(bookent.getNoOfPages());
			book.setGenere(bookent.getGenere());
			book.setImage(bookent.getImage());
			booklist.add(book);
		}

		return booklist;

	}

	@Override
	public List<Book> findAllOrderByBookNameAsc() {
		String query = " select b FROM BookEntity b  ORDER BY bookName ASC";
		List<Book> bookList = new ArrayList<Book>();
		Query query1 = entityManager.createQuery(query);
		List<BookEntity> bookEntityList = query1.getResultList();
		for (BookEntity bookent : bookEntityList) {
			Book book = new Book();
			book.setBookAuthor(bookent.getBookAuthor());
			book.setBookName(bookent.getBookName());
			book.setGenere(bookent.getGenere());
			book.setNoOfPages(bookent.getNoOfPages());
			book.setPrice(bookent.getPrice());
			book.setImage(bookent.getImage());
			// user.setUserName(userent.getUserName());
			bookList.add(book);

		}

		return bookList;

	}

	@Override
	public ArrayList<Book> addBook(Book book) {
		books.add(book);
		System.out.println("hi from BooksDAO");
		return books;
	}

}

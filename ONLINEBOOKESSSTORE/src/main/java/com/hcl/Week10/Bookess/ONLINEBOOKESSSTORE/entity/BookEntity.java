package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int bookId;
	String bookName;
	String bookAuthor;
	int price;
	int noOfPages;
	String genere;
	String image;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", price="
				+ price + ", noOfPages=" + noOfPages + ", genere=" + genere + ", image=" + image + "]";
	}

	

}

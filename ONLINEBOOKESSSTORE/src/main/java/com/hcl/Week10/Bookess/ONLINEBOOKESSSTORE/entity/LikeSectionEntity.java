package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likeSection")
public class LikeSectionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int likeSectionId;
	int bookId;
	int userId;
	String bookName;

	public int getLikeSectionId() {
		return likeSectionId;
	}

	public void setLikeSectionId(int likeSectionId) {
		this.likeSectionId = likeSectionId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}

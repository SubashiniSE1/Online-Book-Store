package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model;

public class LikeSection {
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

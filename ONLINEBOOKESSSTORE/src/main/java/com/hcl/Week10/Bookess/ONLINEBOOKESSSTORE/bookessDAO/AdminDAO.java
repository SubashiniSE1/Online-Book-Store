package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

public interface AdminDAO {
	public int addUser(User user);

	public User login(User user);

}

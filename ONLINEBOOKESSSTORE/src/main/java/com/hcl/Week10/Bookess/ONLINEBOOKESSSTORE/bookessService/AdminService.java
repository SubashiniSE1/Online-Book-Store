package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

public interface AdminService {
	public String addUser(User user);

	public int login(User user) throws Exception;

}

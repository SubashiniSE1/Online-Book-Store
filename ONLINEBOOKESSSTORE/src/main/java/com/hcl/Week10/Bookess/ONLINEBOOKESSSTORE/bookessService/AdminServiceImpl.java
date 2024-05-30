package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO.AdminDAO;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO adminDao;

	@Override
	public String addUser(User user) {
		adminDao.addUser(user);
		return null;
	}

	@Override
	public int login(User user) throws Exception {

		System.out.println("calling dao");
		User users = adminDao.login(user);
		System.out.println("username = " + user.getUserName());
		System.out.println(users);
		int counter = 0;
		if (users == null) {
			System.out.println("No user Found");
			throw new Exception("InValid userName and Password");

		}
		if (user.getUserName().equals(users.getUserName()) && user.getPassword().equals(users.getPassword())) {
			return 1;
		}

		else {
			throw new Exception("InValid userName and Password ");
		}
	}

}

package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO.UserDAO;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.LikeSection;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.ReadLater;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userdao;

	@Override
	public String addUser(User user) {
		userdao.addUser(user);
		return null;

	}

	@Override
	public String editUser(User user) {
		userdao.editUser(user);

		return null;
	}

	@Override
	public String deleteUser(String userName) {

		int resp = userdao.deleteUser(userName);
		return null;
	}

	@Override
	public List<User> getUsers() {

		return userdao.getUser();
	}

	@Override
	public String addReadLater(ReadLater readLater) {
		userdao.addreadLater(readLater);
		return null;
	}

	@Override
	public List<ReadLater> getReadLaterType(int userId) {
		return userdao.getReadLaterBooks(userId);

	}

	@Override
	public String addLikeSection(LikeSection likeSection) {
		userdao.addLikeSection(likeSection);
		return null;
	}

	@Override
	public List<LikeSection> getLikeSection(int userId) {

		return userdao.getLikedSection(userId);
	}

	@Override
	public int login(User user) throws Exception {

		System.out.println("calling dao");
		User users = userdao.login(user);
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

	@Override
	public void addUsername(String userName) {
		userdao.addUsername(userName);

	}

	@Override
	public List<User> findAllOrderByNameAsc() {

		// var sort = Sort(Sort.Direction.ASC,"userName");

		return userdao.findAllOrderByNameAsc();
	}

}



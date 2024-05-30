package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessService;

import java.util.List;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.LikeSection;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.ReadLater;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

public interface UserService {

	public int login(User user) throws Exception;

	public String addUser(User user);

	public String editUser(User users);

	public String deleteUser(String userName);

	public List<User> getUsers();

	public String addReadLater(ReadLater readLater);

	public List<ReadLater> getReadLaterType(int userId);

	public String addLikeSection(LikeSection likeSection);

	public List<LikeSection> getLikeSection(int userId);

	public void addUsername(String userName);

	public List<User> findAllOrderByNameAsc();

}

package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.LikeSection;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.ReadLater;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

public interface UserDAO {
	public User login(User users);

	public int addUser(User user);

	public int deleteUser(String userName);

	public int editUser(User user);

	public List<User> getUser();

	public int addreadLater(ReadLater readLater);

	public List<ReadLater> getReadLaterBooks(int userId);

	public int addLikeSection(LikeSection likeSection);

	public List<LikeSection> getLikedSection(int userId);

	public void addUsername(String userName);

	@Query("FROM user ORDER BY userName ASC")
	public List<User> findAllOrderByNameAsc();

}

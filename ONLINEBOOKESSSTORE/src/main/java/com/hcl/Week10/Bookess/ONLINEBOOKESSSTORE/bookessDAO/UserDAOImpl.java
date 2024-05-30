package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.*;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity.DataEntity;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity.LikeSectionEntity;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity.ReadLaterEntity;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity.UserEntity;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.LikeSection;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.ReadLater;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public UserDAOImpl(EntityManager entityManager) {

		this.entityManager = entityManager;

	}

	@Override
	public int addUser(User user) {

		UserEntity ue = new UserEntity();
		ue.setUserName(user.getUserName());
		ue.setPassword(user.getPassword());
		ue.setEmailId(user.getEmailId());
		ue.setFirstName(user.getFirstName());
		ue.setLastName(user.getLastName());
		ue.setPhoneNo(user.getPhoneNo());
		entityManager.persist(ue);

		System.out.println("persist");
		return 1;

	}

	@Override
	public int deleteUser(String userName) {
		String query = "delete from UserEntity where userName=?1";

		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, userName);
		return query1.executeUpdate();

	}

	@Override
	public int editUser(User user) {

		String query = " update UserEntity set firstName=?1 ,lastName=?2,emailId=?3,password=?4,phoneNo=?5 where userName=?6";
		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, user.getFirstName());
		query1.setParameter(2, user.getLastName());
		query1.setParameter(3, user.getEmailId());
		query1.setParameter(4, user.getPassword());
		query1.setParameter(5, user.getPhoneNo());
		query1.setParameter(6, user.getUserName());
		System.out.println(query1);
		return query1.executeUpdate();

	}

	@Override
	public List<User> getUser() {
		String query = "select ue from UserEntity ue";
		List<User> userList = new ArrayList<User>();
		Query query1 = entityManager.createQuery(query);
		List<UserEntity> userEntityList = query1.getResultList();
		for (UserEntity userent : userEntityList) {
			User user = new User();
			user.setEmailId(userent.getEmailId());
			user.setFirstName(userent.getFirstName());
			user.setLastName(userent.getLastName());
			user.setPassword(userent.getPassword());
			user.setPhoneNo(userent.getPhoneNo());
			user.setUserName(userent.getUserName());
			userList.add(user);

		}

		return userList;
	}

	@Override
	public int addreadLater(ReadLater readLater) {

		String sql = "select r from ReadLaterEntity  r where userId =?1 and bookId=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, readLater.getUserId());
		query.setParameter(1, readLater.getBookId());
		List RE = query.getResultList();
		if (RE.isEmpty()) {

			System.out.println("äddreadlater DAO");
			ReadLaterEntity ue = new ReadLaterEntity();
			ue.setBookId(readLater.getBookId());
			ue.setBookName(readLater.getBookName());
			ue.setUserId(readLater.getUserId());

			entityManager.persist(ue);

			System.out.println("persist");
			return 1;
		} else {
			return 0;
		}

	}



	

	@Override
	public List<ReadLater> getReadLaterBooks(int userId) {

		String query = "select c from ReadLaterEntity c where userId=?1";
		Query query1 = entityManager.createQuery(query);
		System.out.println("query create");

		query1.setParameter(1, userId);

		List<ReadLaterEntity> readLater = query1.getResultList();
		List<ReadLater> readLaterList = new ArrayList<ReadLater>();
		for (ReadLaterEntity re : readLater) {

			ReadLater readLater1 = new ReadLater();

			readLater1.setBookId(re.getBookId());
			readLater1.setBookName(re.getBookName());
			readLater1.setUserId(re.getUserId());

			readLaterList.add(readLater1);
		}

		return readLaterList;

	}

	@Override
	public int addLikeSection(LikeSection likeSection) {
		System.out.println("äddreadlater DAO");
		LikeSectionEntity ue = new LikeSectionEntity();
		ue.setBookId(likeSection.getBookId());
		ue.setBookName(likeSection.getBookName());
		ue.setUserId(likeSection.getUserId());

		entityManager.persist(ue);

		System.out.println("persist");
		return 1;

	}

	@Override
	public List<LikeSection> getLikedSection(int userId) {
		String query = "select l from LikeSectionEntity l where userId=?1";
		Query query1 = entityManager.createQuery(query);
		System.out.println("query create");

		query1.setParameter(1, userId);
//		System.out.println(query + " in DAO");

		List<LikeSectionEntity> likeSec = query1.getResultList();

		List<LikeSection> likeSectionList = new ArrayList<LikeSection>();
		for (LikeSectionEntity likeSection : likeSec) {

			LikeSection ls = new LikeSection();

			ls.setBookId(likeSection.getBookId());
			ls.setBookName(likeSection.getBookName());
			ls.setUserId(likeSection.getUserId());

			likeSectionList.add(ls);
		}
		return likeSectionList;
	}

	@Override
	public User login(User users) {

		String sql = " select  u from UserEntity u where userName = ?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, users.getUserName());
		List<UserEntity> uel = query.getResultList();
		UserEntity ue = uel.get(0);

//		UserEntity ue = entityManager.find(UserEntity.class, users.getUserName());
		if (ue == null) {
			System.out.println(ue);

			return null;

		} else {
			User user = new User();
			user.setUserName(ue.getUserName());
			user.setPassword(ue.getPassword());

			return user;

		}
	}

	@Override
	public void addUsername(String userName) {
		DataEntity da = entityManager.find(DataEntity.class, 1);
		da.setUserName(userName);
		System.out.println(da.getUserName());
		System.out.println(da.getId());
		String sql = "update DataEntity set userName=?1 where id=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, userName);
		int id = 1;
		query.setParameter(2, id);
		query.executeUpdate();
	}

	@Override
	public List<User> findAllOrderByNameAsc() {

		String query = " select u FROM UserEntity u  ORDER BY userName ASC";
		List<User> userList = new ArrayList<User>();
		Query query1 = entityManager.createQuery(query);
		List<UserEntity> userEntityList = query1.getResultList();
		for (UserEntity userent : userEntityList) {
			User user = new User();
			user.setEmailId(userent.getEmailId());
			user.setFirstName(userent.getFirstName());
			user.setLastName(userent.getLastName());
			user.setPassword(userent.getPassword());
			user.setPhoneNo(userent.getPhoneNo());
			user.setUserName(userent.getUserName());
			userList.add(user);

		}

		return userList;

	}


}

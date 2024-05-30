package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.bookessDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.entity.UserEntity;
import com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model.User;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	public AdminDAOImpl(EntityManager entityManager) {
		
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
	public User login(User user) {
		String sql = " select  u from UserEntity u where userName = ?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, user.getUserName());
		List<UserEntity> uel = query.getResultList();
		UserEntity ue = uel.get(0);
		if (ue == null) {
			System.out.println(ue);

			return null;

		} else {
			User user1 = new User();
			user1.setUserName(ue.getUserName());
			user1.setPassword(ue.getPassword());

			return user;

		}
	}

	
	
}

package com.cg.onlineTest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineTest.entities.Test;
import com.cg.onlineTest.entities.User;

@Repository("DaoTestClass")
@Transactional
public class DaoTestClass {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean AddUser(User user) {
		entityManager.persist(user);
		return true;
	}
	
	public boolean addTest(Test test) {
		entityManager.persist(test);
		return true;
	}
	
	public User getAllUserList(){
		String statement = "SELECT user FROM User user";
		 TypedQuery<User> query = entityManager.createQuery(statement, User.class);
		List<User> userList = query.getResultList();
		return userList.get(0);
	}
	
	public Test getAllTestList(){
		String statement = "SELECT user FROM Test user";
		 TypedQuery<Test> query = entityManager.createQuery(statement, Test.class);
		List<Test> userList = query.getResultList();
		return userList.get(0);
	}
	
	
}

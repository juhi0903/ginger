package com.globocom.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globocom.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	    return user.getId();
	}

	@Override
	public User getUser(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<User> cq = cb.createQuery(User.class);
	      Root<User> root = cq.from(User.class);
	      cq.select(root);
	      Query<User> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public void updateUser(long id, User user) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean submitLogin(String username, String password) {
		List<User> user = sessionFactory.getCurrentSession().createNativeQuery("select count(*) from users where username = ?1 and password = ?2")
		.setParameter(1,username).setParameter(2, password).list();
		
		System.out.println(username);
		
		if(user.size() == 1)
			return true;
		
		// TODO Auto-generated method stub
		return false;
	}

	   
}

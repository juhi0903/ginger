package com.globocom.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globocom.model.Category;
import com.globocom.model.User;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long saveCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
	    return category.getId();
	}

	@Override
	public List<Category> getCategory(int contentid) {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Category> cq = cb.createQuery(Category.class);
	     Root<Category> root = cq.from(Category.class);
	     cq.where(cb.equal(root.get("contentid"), contentid),cb.equal(root.get("status"), 1));
	     cq.select(root);
	     Query<Category> query = session.createQuery(cq);
	     return query.getResultList();

	}

	@Override
	public boolean deleteCategory(int id) {
		
		 Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaUpdate<Category> category = cb.createCriteriaUpdate(Category.class);
	     Root<Category> root = category.from(Category.class);
	     
	     category.set("status", 0);
	     category.where(cb.equal(root.get("id"), id));
	     
	     int count = session.createQuery(category).executeUpdate();
	     if(count == 1)
	       return true;
	     else
	    	return false;
	}

	@Override
	public boolean updateCategory(int id, String name) {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaUpdate<Category> category = cb.createCriteriaUpdate(Category.class);
	    Root<Category> root = category.from(Category.class);
	    
	    category.set("name", name);
	    category.where(cb.equal(root.get("id"), id));
	     
	    int count = session.createQuery(category).executeUpdate();
	    if(count == 1)
		   return true;
		else
		   return false;
	}

}

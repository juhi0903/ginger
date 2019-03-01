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
	    return category.getCm_id();
	}

	@Override
	public List<Category> getCategoryList(int contentid) {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Category> cq = cb.createQuery(Category.class);
	     Root<Category> root = cq.from(Category.class);
	     cq.where(cb.equal(root.get("cm_ct_id"), contentid),cb.equal(root.get("cm_status"), 1));
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
	     
	     category.set("cm_status", 0);
	     category.where(cb.equal(root.get("cm_id"), id));
	     
	     int count = session.createQuery(category).executeUpdate();
	     if(count == 1)
	       return true;
	     else
	    	return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaUpdate<Category> ct = cb.createCriteriaUpdate(Category.class);
	    Root<Category> root = ct.from(Category.class);
	    
	    ct.set("cm_name", category.getCm_name());
	    ct.set("cm_updatedon", category.getCm_updatedon());
	    ct.set("cm_name_arabic", category.getCm_name_arabic());
	    ct.set("cm_name_russian", category.getCm_name_russian());
	    ct.set("cm_name_french", category.getCm_name_french());
	    ct.set("cm_name_italic", category.getCm_name_italic());
	    ct.set("cm_name_greek", category.getCm_name_greek());
	    ct.set("cm_name_thai", category.getCm_name_thai());
	    ct.where(cb.equal(root.get("cm_id"),category.getCm_id()));
	     
	    int count = session.createQuery(ct).executeUpdate();
	    if(count == 1)
		   return true;
		else
		   return false;
	}

	@Override
	public List<Category> getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Category> cq = cb.createQuery(Category.class);
	     Root<Category> root = cq.from(Category.class);
	     cq.where(cb.equal(root.get("cm_id"), id));
	     cq.select(root);
	     Query<Category> query = session.createQuery(cq);
	     return query.getResultList();
	}

}

package com.globocom.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globocom.model.Content;

@Repository
public class ContentUploadDaoImpl implements ContentUploadDao {
	@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public void saveContent(Content content) {
		sessionFactory.getCurrentSession().save(content);
	}

}

package com.globocom.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globocom.model.Portal;



@Repository
public class PortalDaoImpl implements PortalDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Portal portal) {
		sessionFactory.getCurrentSession().save(portal);
	    return portal.getPm_id();
		
	}

	@Override
	public Portal get(int id) {
		return sessionFactory.getCurrentSession().get(Portal.class, id);
	}

	@Override
	public List<Portal> list() {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Portal> cq = cb.createQuery(Portal.class);
	     Root<Portal> root = cq.from(Portal.class);
	     cq.select(root);
	     Query<Portal> query = session.createQuery(cq);
	     List<Portal> result = query.getResultList();
	     return result;
	}

	@Override
	public int update(Portal portal) {
		
		Portal obj = sessionFactory.getCurrentSession().load(Portal.class, new Integer(portal.getPm_id()));
		
		portal.setPm_addedon(obj.getPm_addedon());
		portal.setPm_status(obj.getPm_status());
		portal.setPm_logo(obj.getPm_logo());
		
		sessionFactory.getCurrentSession().evict(obj);
		sessionFactory.getCurrentSession().update(portal);
		return portal.getPm_id();
	}

}

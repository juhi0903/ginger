package com.globocom.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globocom.model.Content;
import com.globocom.model.Content_Portal_Mapping;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Content_Portal_Mapping> getPortalMappingList() {
		List<Content_Portal_Mapping> mappingList = new ArrayList<>();

		List<Object> data = sessionFactory.getCurrentSession().
				createNativeQuery("select cm.portal_id,cm.country_id,cm.operator_id, c.name as countryname, op.name as operatorname, pm.pm_title , c.shortname , cm.cpm_biller_name"
						+ " from content_portal_mapping cm, country c , operator op, portal_master pm "
						+ " where cm.portal_id = pm.pm_id AND c.id = cm.country_id AND op.id = cm.operator_id  GROUP BY 1,2,3,8;").list();

		Iterator itr = data.iterator();

		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			Content_Portal_Mapping tempdata = new Content_Portal_Mapping();
			tempdata.setPortal_id(Integer.parseInt(String.valueOf(obj[0])));
			tempdata.setCountry_id(Integer.parseInt(String.valueOf(obj[1])));
			tempdata.setOperator_id(Integer.parseInt(String.valueOf(obj[2])));
			tempdata.setCountry_name(String.valueOf(obj[3]));
			tempdata.setOperator_name(String.valueOf(obj[4]));
			tempdata.setPm_name(String.valueOf(obj[5]));
			tempdata.setCm_name(String.valueOf(obj[6]));
			tempdata.setCpm_biller_name(String.valueOf(obj[7]));
			
			mappingList.add(tempdata);
		}

		return mappingList;
	}

}

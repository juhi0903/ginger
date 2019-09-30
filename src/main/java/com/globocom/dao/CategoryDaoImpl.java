package com.globocom.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globocom.model.Category;
import com.globocom.model.Content;
import com.globocom.model.ContentProvider;
import com.globocom.model.Country;
import com.globocom.model.Operator;
import com.globocom.model.Portal;
import com.globocom.model.User;
import com.globocom.model.Content_Portal_Mapping;


@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long saveCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		}
		catch(Exception e) {
			sessionFactory.getCurrentSession().save(category);
		}
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

	@Override
	public List<Country> getCountry() {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Country> cq = cb.createQuery(Country.class);
	     Root<Country> root = cq.from(Country.class);
	     cq.select(root);
	     Query<Country> query = session.createQuery(cq);
	     List<Country> result = query.getResultList();
	     return result;
	}

	@Override
	public List<Operator> getOperator(int id) {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Operator> cq = cb.createQuery(Operator.class);
	     Root<Operator> root = cq.from(Operator.class);
	     cq.where(cb.equal(root.get("territoryid"), id));
	     cq.select(root);
	     Query<Operator> query = session.createQuery(cq);
	     return query.getResultList();
	}

	@Override
	public int saveContentPortalMapping(Content_Portal_Mapping portalMapping) {
		sessionFactory.getCurrentSession().save(portalMapping);
	    return portalMapping.getCmp_id();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Content> getContentList(int contentType,int categoryId,int portalId, int operatorId){
		List<Content> contentList = new ArrayList<Content>();
		List<Object> data = sessionFactory.getCurrentSession().
				createNativeQuery(" SELECT "
						+ "(SELECT 'true' from content_portal_mapping "
						+ "WHERE portal_id = ?1 AND  operator_id =?2 AND cpm_status ='1' "
						+ "AND category_id = cdm_cm_id AND content_type_id = cdm_ct_id AND content_id=cdm_id LIMIT 1  ) selected, "
						+ "(Select cpname from content_provider where id=cdm_cp limit 1) cpName, "
						+ "cdm_id  , cdm_ct_id , cdm_cm_id , cdm_cp , cdm_title ,cdm_status,date(cdm_addedon), cdm_content_path , cdm_url "
						+ "FROM content_data_master "
						+ "WHERE cdm_ct_id=?3 AND cdm_cm_id=?4 AND cdm_status='APPROVED'").
						setParameter(1, portalId).setParameter(2,operatorId).setParameter(3, contentType).setParameter(4, categoryId).list();
				
		
		Iterator itr = data.iterator();
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			Content content = new Content();
			content.setCdm_live(String.valueOf(obj[0]));
			content.setCdm_cp(String.valueOf(obj[1]));
			content.setCdm_id(Integer.parseInt(String.valueOf(obj[2])));
			content.setCdm_title(String.valueOf(obj[6]));
			content.setCdm_status(String.valueOf(obj[7]));
			content.setCdm_addedon(String.valueOf(obj[8]));
			content.setCdm_content_path(String.valueOf(obj[9]));
			content.setCdm_url(String.valueOf(obj[10]));
			contentList.add(content);
			
		}

				
//	     CriteriaBuilder cb = session.getCriteriaBuilder();
//	     CriteriaQuery<Content> cq = cb.createQuery(Content.class);
//	     Root<Content> root = cq.from(Content.class);
//	     cq.where(cb.equal(root.get("cdm_ct_id"), contentType),cb.equal(root.get("cdm_cm_id"), categoryId));
//	     cq.select(root);
//	     Query<Content> query = session.createQuery(cq);
//	     System.out.println(query.getResultList());
        return contentList;
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Content_Portal_Mapping> getContentMappingList(int portalid,int categoryId,int operatorid) {
		List<Content_Portal_Mapping> contentMapping = new ArrayList<Content_Portal_Mapping>();
		List<Object> user = sessionFactory.getCurrentSession().
						createNativeQuery("select a.cmp_id as cmp_id, a.cpm_status as cpm_status,a.cpm_addedon as cpm_addedon,b.ct_name as ct_name, "
						+ "c.name as country_name,d.name as operator_name,e.pm_name as pm_name,f.cm_name as cm_name,g.cdm_title as cdm_title, "
						+ "g.cdm_content_path as cdm_content_path, cp.cpname as cpname \n" + 
						"from \n" + 
						"	content_portal_mapping a,\n" + 
						"	content_type b,\n" + 
						"	country c,\n" + 
						"	operator d,\n" + 
						"	portal_master e,\n" + 
						"	category_mastr f , \n" + 
						"	content_data_master g,\n" + 
						"   content_provider cp \n "+
						"where \n" + 
						"	a.portal_id = ?1 and\n" + 
						"	a.operator_id = ?2 and \n" + 
						"	a.content_type_id = ?3 and \n" + 
						"	a.country_id =  c.id and \n" + 
						"	a.operator_id =d.id AND\n" + 
						"	a.portal_id = e.pm_id AND\n" + 
						"	a.category_id = f.cm_id AND\n" + 
						"	a.content_id = g.cdm_id  and \n"+ 
						" 	g.cdm_cp = cp.id AND \n"+
						"   a.content_type_id = b.ct_id and a.cpm_status='1' order by a.cpm_addedon desc").setParameter(1,portalid).setParameter(2, operatorid).setParameter(3, categoryId).list();
				
		Iterator itr = user.iterator();
		while(itr.hasNext()){
			
			Object[] obj = (Object[]) itr.next();
			Content_Portal_Mapping tempCpMapping = new Content_Portal_Mapping();
			tempCpMapping.setCmp_id(Integer.parseInt(String.valueOf(obj[0])));
			if(Integer.parseInt(String.valueOf(obj[1]))==1)
			tempCpMapping.setCpm_status("Active");
			else if(Integer.parseInt(String.valueOf(obj[1]))== 0)
			tempCpMapping.setCpm_status("Pause");
			tempCpMapping.setCpm_addedon(String.valueOf(obj[2]).substring(0,11));
			tempCpMapping.setCt_name(String.valueOf(obj[3]));
			tempCpMapping.setCountry_name(String.valueOf(obj[4]));
			tempCpMapping.setOperator_name(String.valueOf(obj[5]));
			tempCpMapping.setPm_name(String.valueOf(obj[6]));
			tempCpMapping.setCm_name(String.valueOf(obj[7]));
			tempCpMapping.setCdm_title(String.valueOf(obj[8]));
			tempCpMapping.setCdm_content_path(String.valueOf(obj[9]));
			tempCpMapping.setCpname(String.valueOf(obj[10]));
			contentMapping.add(tempCpMapping);
		  
		}
		
//		Session session = sessionFactory.getCurrentSession();
//	     CriteriaBuilder cb = session.getCriteriaBuilder();
//	     CriteriaQuery<Object> cq = cb.createQuery(Object.class);
//	     Root<Object> root = cq.from(Object.class);
//	     cq.where(cb.equal(root.get("portal_id"), portalid),cb.equal(root.get("operator_id"), operatorid),cb.equal(root.get("category_id"), categoryId));
//	     cq.select(root);
//	     Query<Object> query = session.createQuery(cq);
//	     System.out.println(query.getResultList());
	     return contentMapping;
	}

	@Override
	public int changeContentStatus(int id, String status) {

		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaUpdate<Content_Portal_Mapping> cpm = cb.createCriteriaUpdate(Content_Portal_Mapping.class);
	    Root<Content_Portal_Mapping> root = cpm.from(Content_Portal_Mapping.class);
	    cpm.set("cpm_status", status);
	    cpm.where(cb.equal(root.get("cmp_id"),id));

	    int count = session.createQuery(cpm).executeUpdate();
	    
	    return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Content> getContent(int contentType, String categoryId, String status) {
		List<Content> contentList = new ArrayList<>();
		
		List<Object> data = sessionFactory.getCurrentSession().
				createNativeQuery("select cdm_id,cdm_ct_id,cdm_cm_id,cdm_title,cpname,date(cdm_addedon),status,cdm_content_path,cdm_url  from content_data_master cd ,content_provider cp"
						+ " where cd.cdm_cp = cp.id and cd.cdm_cm_id=?1 and cd.cdm_ct_id=?2 and cd.cdm_status=?3 and cdm_content_path NOT LIKE '%xlsx' order by cdm_addedon desc;")
						.setParameter(1,categoryId).setParameter(2, contentType).setParameter(3, status).list();
		
		Iterator itr = data.iterator();
		
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			Content tempdata = new Content();
			tempdata.setCdm_id(Integer.parseInt(String.valueOf(obj[0])));
			tempdata.setCdm_ct_id(Integer.parseInt(String.valueOf(obj[1])));
			tempdata.setCdm_cm_id(String.valueOf(obj[2]));
			tempdata.setCdm_title(String.valueOf(obj[3]));
			tempdata.setCdm_cp(String.valueOf(obj[4]));
			tempdata.setCdm_addedon(String.valueOf(obj[5]));
			tempdata.setCdm_status(String.valueOf(obj[6]));
			tempdata.setCdm_content_path(String.valueOf(obj[7]));
			tempdata.setCdm_url(String.valueOf(obj[8]));
			contentList.add(tempdata);
		}

	     return contentList;
	}


	@Override
	public int approveOrRejectContent(int id, String status) {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaUpdate<Content> ct = cb.createCriteriaUpdate(Content.class);
	    Root<Content> root = ct.from(Content.class);
	    
	    ct.set("cdm_status", status);
	    ct.where(cb.equal(root.get("cdm_id"),id));

	    int count = session.createQuery(ct).executeUpdate();
	    return count;
	}

	@Override
	public long saveContentProvider(ContentProvider contentprovider) {
		try {
			sessionFactory.getCurrentSession().save(contentprovider);
		}
		catch(Exception e) {
			sessionFactory.getCurrentSession().save(contentprovider);
		}
		return contentprovider.getId();
	}

	@Override
	public List<Content> getHtmlGamesExcel(int id , int cp) {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Content> cq = cb.createQuery(Content.class);
	     Root<Content> root = cq.from(Content.class);
	     cq.where(cb.equal(root.get("cdm_cm_id"), 1),cb.equal(root.get("cdm_ct_id"), id),cb.equal(root.get("cdm_cp"), cp),cb.like(root.get("cdm_content_path"), "%xlsx"));
	     cq.select(root);
	     Query<Content> query = session.createQuery(cq);
	     return query.getResultList();
	}

	@Override
	public List<ContentProvider> getContentProvider() {
		Session session = sessionFactory.getCurrentSession();
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<ContentProvider> cq = cb.createQuery(ContentProvider.class);
	     Root<ContentProvider> root = cq.from(ContentProvider.class);
	     cq.select(root);
	     Query<ContentProvider> query = session.createQuery(cq);
	     List<ContentProvider> result = query.getResultList();
	     return result;
	}

	@Override
	public int removeContentMapping(int id) {
		Session session = sessionFactory.getCurrentSession();
		Content_Portal_Mapping cpMapping = new Content_Portal_Mapping();
		cpMapping.setCmp_id(id);
		session.delete(cpMapping);
		return 1;
	}

}

package com.globocom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globocom.dao.CategoryDao;
import com.globocom.model.Content_Portal_Mapping;
import com.globocom.model.Category;
import com.globocom.model.Content;
import com.globocom.model.Country;
import com.globocom.model.Operator;

@Service
@Transactional(readOnly = false)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categorydao;
	
	@Transactional
	@Override
	public long saveCategory(Category category) {
		return categorydao.saveCategory(category);
	}

	@Override
	public List<Category> getCategoryList(int contentid) {
		return categorydao.getCategoryList(contentid);
	}

	@Override
	public boolean deleteCategory(int id) {
		return categorydao.deleteCategory(id);
	}

	@Override
	public boolean updateCategory(Category category) {
		return categorydao.updateCategory(category);
	}

	@Override
	public List<Category> getCategory(int id) {
		return categorydao.getCategory(id);
	}

	@Override
	public List<Country> getCountry() {
		return categorydao.getCountry();
	}

	@Override
	public List<Operator> getOperator(int id) {
		return categorydao.getOperator(id);
	}

	@Override
	public int saveContentPortalMapping(Content_Portal_Mapping portalMapping) {
		 return categorydao.saveContentPortalMapping(portalMapping);		
	}

	@Override
	public List<Content> getContentList(int contentType, int categoryId) {
		return categorydao.getContentList(contentType,categoryId);
	}

	@Override
	public List<Content_Portal_Mapping> getContentMappingList(int portalid,int categoryId,int operatorid) {
		return categorydao.getContentMappingList(portalid,categoryId,operatorid);
	}

	@Override
	public int changeContentStatus(int id, String status) {
		return categorydao.changeContentStatus(id, status);
	}

	@Override
	public List<Content> getContent(int contentType, int categoryId, String status) {
		return categorydao.getContent(contentType, categoryId, status);
	}

	@Override
	public int approveOrRejectContent(int id, String status) {
		return categorydao.approveOrRejectContent(id, status);
	}


}

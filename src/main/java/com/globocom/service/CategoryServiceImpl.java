package com.globocom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globocom.dao.CategoryDao;
import com.globocom.model.Category;

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

}

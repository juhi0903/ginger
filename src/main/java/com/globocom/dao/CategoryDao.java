package com.globocom.dao;

import java.util.List;

import com.globocom.model.Category;

public interface CategoryDao {
	
	long saveCategory(Category category);
	
	List<Category> getCategory(int id);
	
	boolean deleteCategory(int id);
	
	boolean updateCategory(Category category);

	List<Category> getCategoryList(int contentid);
}

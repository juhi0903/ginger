package com.globocom.dao;

import java.util.List;

import com.globocom.model.Category;

public interface CategoryDao {
	
	long saveCategory(Category category);
	
	List<Category> getCategory(int contentid);
	
	boolean deleteCategory(int id);
	
	boolean updateCategory(int id, String name);
}

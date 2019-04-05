package com.globocom.dao;

import java.util.List;

import com.globocom.model.Category;
import com.globocom.model.Country;
import com.globocom.model.Operator;
import com.globocom.model.Content_Portal_Mapping;


public interface CategoryDao {
	
	long saveCategory(Category category);
	
	List<Category> getCategory(int id);
	
	boolean deleteCategory(int id);
	
	boolean updateCategory(Category category);

	List<Category> getCategoryList(int contentid);
	
	List<Country> getCountry();
	
	List<Operator> getOperator(int id);
	
	int saveContentPortalMapping(Content_Portal_Mapping portalMapping);

}

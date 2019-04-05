package com.globocom.service;

import java.util.List;

import com.globocom.model.Content_Portal_Mapping;
import com.globocom.model.Category;
import com.globocom.model.Country;
import com.globocom.model.Operator;

public interface CategoryService {
	
	long saveCategory(Category category);
	
	List<Category> getCategoryList(int contentid);
	
	boolean deleteCategory(int id);
	
	boolean updateCategory(Category category);
	
	List<Category> getCategory(int id);
	
	List<Country> getCountry();
	
	List<Operator> getOperator(int id);
	
	int saveContentPortalMapping(Content_Portal_Mapping portalMapping);


}

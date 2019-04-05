package com.globocom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globocom.model.Content_Portal_Mapping;
import com.globocom.model.Category;
import com.globocom.model.Content;
import com.globocom.model.Country;
import com.globocom.model.Operator;
import com.globocom.model.User;
import com.globocom.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
	@PostMapping("/category")
	   public ResponseEntity<?> save(@RequestBody Category category) {
			Date parsedDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			category.setCm_addedon(formatter.format(parsedDate));
			category.setCm_updatedon(formatter.format(parsedDate));
			category.setCm_status("1");
			long id = categoryservice.saveCategory(category);
			return ResponseEntity.ok().body("New Catgory Added With id" + id);
	  }

	@GetMapping("/content/{contentid}")
	   public ResponseEntity<List<Category>> getCategoryList(@PathVariable("contentid") int contentid) {
		List<Category> category = categoryservice.getCategoryList(contentid);
	     return ResponseEntity.ok().body(category);
	  }
	
	@DeleteMapping("/category/{id}")
	   public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") int id) {
		boolean result = categoryservice.deleteCategory(id);
	     return ResponseEntity.ok().body(result);
	  }
	
	@PutMapping("/category")
	   public ResponseEntity<Boolean> updateCategory(@RequestBody Category category) {
		Date parsedDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		category.setCm_updatedon(formatter.format(parsedDate));
		boolean result  = categoryservice.updateCategory(category);
		return ResponseEntity.ok().body(result);
	  }
	
	@GetMapping("/category/{id}")
	   public ResponseEntity<List<Category>> getCategory(@PathVariable("id") int id) {
		List<Category> category = categoryservice.getCategory(id);
	     return ResponseEntity.ok().body(category);
	  }
	
	@PostMapping("/categorymapping")
	public ResponseEntity<?> savePortalMapping(@RequestBody Content_Portal_Mapping portalMapping) {
		Date parsedDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		portalMapping.setCpm_addedon(formatter.format(parsedDate));
		portalMapping.setCpm_updatedon(formatter.format(parsedDate));
		int id = categoryservice.saveContentPortalMapping(portalMapping);
		return ResponseEntity.ok().body("Portal Mapping Done" + id);

	  }
	
	@GetMapping("/country")
	public ResponseEntity<List<Country>> getCountry() {
		List<Country> country = categoryservice.getCountry();
	     return ResponseEntity.ok().body(country);
	  }
	
	@GetMapping("/country/{id}")
	public ResponseEntity<List<Operator>> getOperator(@PathVariable("id") int id) {
		List<Operator> operator = categoryservice.getOperator(id);
	     return ResponseEntity.ok().body(operator);
	  }
	
	@GetMapping("/content/{contentType}/{categoryId}")
	public ResponseEntity<List<Content>> getOperator(@PathVariable("contentType") int contentType,@PathVariable("categoryId") int categoryId) {
		List<Content> content = categoryservice.getContentList(contentType,categoryId);
	     return ResponseEntity.ok().body(content);
	  }
	
	
}

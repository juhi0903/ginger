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

import com.globocom.model.Category;
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
			category.setAddtime(formatter.format(parsedDate));
			category.setEdittime(formatter.format(parsedDate));
			category.setStatus("1");
			System.out.print(category);
			long id = categoryservice.saveCategory(category);
			return ResponseEntity.ok().body("New Catgory Added With id" + id);
	  }

	@GetMapping("/category/{contentid}")
	   public ResponseEntity<List<Category>> getCategory(@PathVariable("contentid") int contentid) {
		List<Category> category = categoryservice.getCategory(contentid);
	     return ResponseEntity.ok().body(category);
	  }
	
	@DeleteMapping("/category/{id}")
	   public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") int id) {
		boolean result = categoryservice.deleteCategory(id);
	     return ResponseEntity.ok().body(result);
	  }
	
	@PutMapping("/category/{id}/{name}")
	   public ResponseEntity<Boolean> updateCategory(@PathVariable("id") int id,@PathVariable("name") String name) {
		boolean result  = categoryservice.updateCategory(id,name);
		return ResponseEntity.ok().body(result);
	  }
}

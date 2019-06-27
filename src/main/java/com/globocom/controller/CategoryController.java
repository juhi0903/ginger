package com.globocom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.globocom.model.ContentProvider;
import com.globocom.model.Country;
import com.globocom.model.Operator;
import com.globocom.model.User;
import com.globocom.service.CategoryService;

@CrossOrigin(origins = {"/**"}, maxAge = 4800, allowCredentials = "false") 

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
		int count = 0;
		Date parsedDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		portalMapping.setCpm_addedon(formatter.format(parsedDate));
		portalMapping.setCpm_updatedon(formatter.format(parsedDate));
		int[] contentId = portalMapping.getContent_array();
		for(int i =0;i< contentId.length ; i++) {
//			System.out.println(contentId[i]);
			portalMapping.setContent_id(contentId[i]);
			portalMapping.setCpm_status("1");
			int id = categoryservice.saveContentPortalMapping(portalMapping);
			count++;
		}
		return ResponseEntity.ok().body(count +" Portal Mapping Done");

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
	public ResponseEntity<List<Content>> getContentList(@PathVariable("contentType") int contentType,@PathVariable("categoryId") int categoryId) {
		List<Content> content = categoryservice.getContentList(contentType,categoryId);
	     return ResponseEntity.ok().body(content);
	  }
	
	@GetMapping("/contentmapping/{portalid}/{categoryId}/{operatorid}")
	public ResponseEntity<List<Content_Portal_Mapping>> getContentMappingList(@PathVariable("portalid") int portalid,@PathVariable("categoryId") int categoryId,@PathVariable("operatorid") int operatorid) {
		System.out.println(operatorid);
		List<Content_Portal_Mapping> contentlist = categoryservice.getContentMappingList(portalid,categoryId,operatorid);
	     return ResponseEntity.ok().body(contentlist);
	  }
	
	@GetMapping("/contentmappingstatus/{id}/{status}")
	public ResponseEntity<?> changeContentStatus(@PathVariable("id") int id, @PathVariable("status") String status) {
		System.out.println(id);
		int result = categoryservice.changeContentStatus(id,status);
	     return ResponseEntity.ok().body(result +" Status Changed");
	  }
	
	@PostMapping("/content")
	   public ResponseEntity<?> getContent(@RequestBody Content content) {
			
		List<Content> contentList = categoryservice.getContent(content.getCdm_ct_id(),content.getCdm_cm_id(),content.getCdm_status());
//		System.out.println(contentList);
	    return ResponseEntity.ok().body(contentList);
	  }
	

	@GetMapping("/content/approve/{id}")
	   public ResponseEntity<?> approveContent(@PathVariable("id") int id) {
		System.out.println("here");
			
		int row = categoryservice.approveOrRejectContent(id,"APPROVED");
//		System.out.println(contentList);
	    return ResponseEntity.ok().body("Content Approved");
	  }
	

	@GetMapping("/content/reject/{id}")
	   public ResponseEntity<?> rejectContent(@PathVariable("id") int id) {
			
		int row  = categoryservice.approveOrRejectContent(id, "REJECTED");
//		System.out.println(contentList);
	    return ResponseEntity.ok().body("Content Rejected");
	  }
	
	@PostMapping("/contentprovider")
	   public ResponseEntity<?> saveContentProvider(@RequestBody ContentProvider contentprovider) {
			
		Date parsedDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		contentprovider.setAddtime(formatter.format(parsedDate));
		contentprovider.setEdittime(formatter.format(parsedDate));
		contentprovider.setStatus("1");
		long id = categoryservice.saveContentProvider(contentprovider);
		return ResponseEntity.ok().body("New CP Added With id " + id);
	  }
	
	
	@GetMapping("/htmlgames/{id}")
	public ResponseEntity<?> getHtmlGamesExcel(@PathVariable("id") int id) {
		
		 List<Content> contentList = categoryservice.getHtmlGamesExcel(id);
		
		 return ResponseEntity.ok().body(contentList);	  
	}
	
}

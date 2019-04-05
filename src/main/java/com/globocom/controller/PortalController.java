package com.globocom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globocom.model.Portal;
import com.globocom.service.PortalService;

@CrossOrigin(origins = {"/**"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class PortalController {

	@Autowired
	PortalService portalservice;
	
	@PostMapping("/portal")
	   public ResponseEntity<?> save(@RequestBody Portal portal) {
			
			Date parsedDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			portal.setPm_addedon(formatter.format(parsedDate));
			portal.setPm_updatedon(formatter.format(parsedDate));
			portal.setPm_status("1");
			portal.setPm_logo("/home/logo");
			
			System.out.println(portal);
			
			int id = portalservice.save(portal);
			return ResponseEntity.ok().body("New Portal has been Registered with ID:" + id);
	  }
	
	@GetMapping("/portal/{id}")
	   public ResponseEntity<Portal> get(@PathVariable("id")  int id) {
		Portal portal = portalservice.get(id);
	    return ResponseEntity.ok().body(portal);
	  }
	
	@GetMapping("/portal")
	public ResponseEntity<List<Portal>> getPortalList(){
		
		List<Portal> portal = portalservice.list();
		return ResponseEntity.ok().body(portal);
	}
	
	@PutMapping("/portal")
	public ResponseEntity<?> update(@RequestBody Portal portal) {
		
		Date parsedDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		portal.setPm_updatedon(formatter.format(parsedDate));
		
//		System.out.println(portal);
		
		int id = portalservice.update(portal);
		return ResponseEntity.ok().body("New Portal has been Registered with ID:" + id);
  }
	
}

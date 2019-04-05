package com.globocom.service;

import java.util.List;

import com.globocom.model.Portal;

public interface PortalService {
	
	int save(Portal portal);
	int update(Portal portal);
	Portal get(int id);
	List<Portal> list();
}

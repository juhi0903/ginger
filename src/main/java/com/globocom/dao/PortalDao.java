package com.globocom.dao;

import java.util.List;

import com.globocom.model.Portal;

public interface PortalDao {
	
	int save(Portal portal);
	
	int update(Portal portal);
	
	Portal get(int id);
	
	List<Portal> list();
}

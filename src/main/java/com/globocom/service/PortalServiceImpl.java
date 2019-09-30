package com.globocom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globocom.dao.PortalDao;
import com.globocom.model.Content_Portal_Mapping;
import com.globocom.model.Portal;

@Service
@Transactional(readOnly = false)
public class PortalServiceImpl implements PortalService {

	@Autowired
	private PortalDao portaldao;
	
	@Transactional
	@Override
	public int save(Portal portal) {
		return portaldao.save(portal);
	}

	@Override
	public Portal get(int id) {
		return portaldao.get(id);
	}

	@Override
	public List<Portal> list() {
		return portaldao.list();
	}

	@Override
	public int update(Portal portal) {
		return portaldao.update(portal);
	}

	@Override
	public List<Content_Portal_Mapping> getPortalMappingList() {
		return portaldao.getPortalMappingList();
	}

}

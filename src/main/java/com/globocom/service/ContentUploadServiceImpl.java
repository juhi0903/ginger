package com.globocom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globocom.dao.ContentUploadDao;
import com.globocom.model.Content;

@Service
@Transactional(readOnly = false)
public class ContentUploadServiceImpl implements ContentUploadService {
	@Autowired
	ContentUploadDao  contentUploadDao;

	@Override
	public void saveContent(Content content) {
		contentUploadDao.saveContent(content);
		
	}

}

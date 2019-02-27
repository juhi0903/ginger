package com.globocom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int contentid;
	
	private String status;
	
	private String addtime;
	
	private String edittime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getEdittime() {
		return edittime;
	}

	public void setEdittime(String edittime) {
		this.edittime = edittime;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", contentid=" + contentid + ", status=" + status
				+ ", addtime=" + addtime + ", edittime=" + edittime + "]";
	}


	
	
}

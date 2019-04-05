package com.globocom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "operator")
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String shortname;
	
	private int status;
	
	private String addtime;
	
	private String edittime;
	
	private int territoryid;

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

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public int getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(int territoryid) {
		this.territoryid = territoryid;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", name=" + name + ", shortname=" + shortname + ", status=" + status
				+ ", addtime=" + addtime + ", edittime=" + edittime + ", territoryid=" + territoryid + "]";
	}
	
	

}

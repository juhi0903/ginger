package com.globocom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content_portal_mapping")
public class Content_Portal_Mapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmp_id;  
	
	private int portal_id;
	
	private int country_id ; 
	
	private int operator_id  ;
	
	private int content_type_id;
	
	private int category_id  ;
	
	private int content_id ;
	
	private String cpm_status;
	
	private String cpm_addedon ;
	
	private String cpm_updatedon;

	public int getCmp_id() {
		return cmp_id;
	}

	public void setCmp_id(int cmp_id) {
		this.cmp_id = cmp_id;
	}

	public int getPortal_id() {
		return portal_id;
	}

	public void setPortal_id(int portal_id) {
		this.portal_id = portal_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}

	public int getContent_type_id() {
		return content_type_id;
	}

	public void setContent_type_id(int content_type_id) {
		this.content_type_id = content_type_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	
	public String getCpm_addedon() {
		return cpm_addedon;
	}

	public void setCpm_addedon(String cpm_addedon) {
		this.cpm_addedon = cpm_addedon;
	}

	public String getCpm_updatedon() {
		return cpm_updatedon;
	}

	public void setCpm_updatedon(String cpm_updatedon) {
		this.cpm_updatedon = cpm_updatedon;
	}

	public String getCpm_status() {
		return cpm_status;
	}

	public void setCpm_status(String cpm_status) {
		this.cpm_status = cpm_status;
	}

	@Override
	public String toString() {
		return "Content_Portal_Mapping [cmp_id=" + cmp_id + ", portal_id=" + portal_id + ", country_id=" + country_id
				+ ", operator_id=" + operator_id + ", content_type_id=" + content_type_id + ", category_id="
				+ category_id + ", content_id=" + content_id + ", cpm_addedon=" + cpm_addedon + ", cpm_updatedon="
				+ cpm_updatedon + "]";
	}

	
	
	
	
	

}

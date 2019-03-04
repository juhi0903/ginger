package com.globocom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_mastr")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cm_id;

	private String cm_name;

	private int cm_ct_id;

	private String cm_status;

	private String cm_addedon;

	private String cm_updatedon;

	private String cm_name_arabic;

	private String cm_name_russian;

	private String cm_name_french;

	private String cm_name_italic;

	private String cm_name_greek;

	private String cm_name_thai;

	public int getCm_id() {
		return cm_id;
	}

	public void setCm_id(int cm_id) {
		this.cm_id = cm_id;
	}

	public String getCm_name() {
		return cm_name;
	}

	public void setCm_name(String cm_name) {
		this.cm_name = cm_name;
	}

	public int getCm_ct_id() {
		return cm_ct_id;
	}

	public void setCm_ct_id(int cm_ct_id) {
		this.cm_ct_id = cm_ct_id;
	}

	public String getCm_status() {
		return cm_status;
	}

	public void setCm_status(String cm_status) {
		this.cm_status = cm_status;
	}

	public String getCm_addedon() {
		return cm_addedon;
	}

	public void setCm_addedon(String cm_addedon) {
		this.cm_addedon = cm_addedon;
	}

	public String getCm_updatedon() {
		return cm_updatedon;
	}

	public void setCm_updatedon(String cm_updatedon) {
		this.cm_updatedon = cm_updatedon;
	}

	public String getCm_name_arabic() {
		return cm_name_arabic;
	}

	public void setCm_name_arabic(String cm_name_arabic) {
		this.cm_name_arabic = cm_name_arabic;
	}

	public String getCm_name_russian() {
		return cm_name_russian;
	}

	public void setCm_name_russian(String cm_name_russian) {
		this.cm_name_russian = cm_name_russian;
	}

	public String getCm_name_french() {
		return cm_name_french;
	}

	public void setCm_name_french(String cm_name_french) {
		this.cm_name_french = cm_name_french;
	}

	public String getCm_name_italic() {
		return cm_name_italic;
	}

	public void setCm_name_italic(String cm_name_italic) {
		this.cm_name_italic = cm_name_italic;
	}

	public String getCm_name_greek() {
		return cm_name_greek;
	}

	public void setCm_name_greek(String cm_name_greek) {
		this.cm_name_greek = cm_name_greek;
	}

	public String getCm_name_thai() {
		return cm_name_thai;
	}

	public void setCm_name_thai(String cm_name_thai) {
		this.cm_name_thai = cm_name_thai;
	}

	@Override
	public String toString() {
		return "Category [cm_id=" + cm_id + ", cm_name=" + cm_name + ", cm_ct_id=" + cm_ct_id + ", cm_status="
				+ cm_status + ", cm_addedon=" + cm_addedon + ", cm_updatedon=" + cm_updatedon + ", cm_name_arabic="
				+ cm_name_arabic + ", cm_name_russian=" + cm_name_russian + ", cm_name_french=" + cm_name_french
				+ ", cm_name_italic=" + cm_name_italic + ", cm_name_greek=" + cm_name_greek + ", cm_name_thai="
				+ cm_name_thai + "]";
	}

	
	 
	 
	
	  


}

package com.globocom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portal_master")
public class Portal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pm_id;

	private String pm_name;
	
	private String pm_logo;
	
	private String pm_title;
	
	private String pm_title_arabic;
	
	private String pm_title_russian;
	
	private String pm_title_french;
	
	private String pm_title_italic;
	
	private String pm_title_greek;
	
	private String pm_title_thai;
	
	private String pm_footer;
	
	private String pm_footer_arabic;
	
	private String pm_footer_russian;
	
	private String pm_footer_french;
	
	private String pm_footer_italic;
	
	private String pm_footer_greek;
	
	private String pm_footer_thai;
	
	private String pm_status;
	
	private String pm_addedon;

	private String pm_updatedon;
	
	private String pm_remarks;

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public String getPm_name() {
		return pm_name;
	}

	public void setPm_name(String pm_name) {
		this.pm_name = pm_name;
	}

	public String getPm_status() {
		return pm_status;
	}

	public void setPm_status(String pm_status) {
		this.pm_status = pm_status;
	}

	public String getPm_logo() {
		return pm_logo;
	}

	public void setPm_logo(String pm_logo) {
		this.pm_logo = pm_logo;
	}

	public String getPm_title() {
		return pm_title;
	}

	public void setPm_title(String pm_title) {
		this.pm_title = pm_title;
	}

	public String getPm_title_arabic() {
		return pm_title_arabic;
	}

	public void setPm_title_arabic(String pm_title_arabic) {
		this.pm_title_arabic = pm_title_arabic;
	}

	public String getPm_title_russian() {
		return pm_title_russian;
	}

	public void setPm_title_russian(String pm_title_russian) {
		this.pm_title_russian = pm_title_russian;
	}

	public String getPm_title_french() {
		return pm_title_french;
	}

	public void setPm_title_french(String pm_title_french) {
		this.pm_title_french = pm_title_french;
	}

	public String getPm_title_italic() {
		return pm_title_italic;
	}

	public void setPm_title_italic(String pm_title_italic) {
		this.pm_title_italic = pm_title_italic;
	}

	public String getPm_title_greek() {
		return pm_title_greek;
	}

	public void setPm_title_greek(String pm_title_greek) {
		this.pm_title_greek = pm_title_greek;
	}

	public String getPm_title_thai() {
		return pm_title_thai;
	}

	public void setPm_title_thai(String pm_title_thai) {
		this.pm_title_thai = pm_title_thai;
	}

	public String getPm_footer() {
		return pm_footer;
	}

	public void setPm_footer_text(String pm_footer) {
		this.pm_footer = pm_footer;
	}

	public String getPm_footer_arabic() {
		return pm_footer_arabic;
	}

	public void setPm_footer_arabic(String pm_footer_arabic) {
		this.pm_footer_arabic = pm_footer_arabic;
	}

	public String getPm_footer_russian() {
		return pm_footer_russian;
	}

	public void setPm_footer_russian(String pm_footer_russian) {
		this.pm_footer_russian = pm_footer_russian;
	}

	public String getPm_footer_french() {
		return pm_footer_french;
	}

	public void setPm_footer_french(String pm_footer_french) {
		this.pm_footer_french = pm_footer_french;
	}

	public String getPm_footer_italic() {
		return pm_footer_italic;
	}

	public void setPm_footer_italic(String pm_footer_italic) {
		this.pm_footer_italic = pm_footer_italic;
	}

	public String getPm_footer_greek() {
		return pm_footer_greek;
	}

	public void setPm_footer_greek(String pm_footer_greek) {
		this.pm_footer_greek = pm_footer_greek;
	}

	public String getPm_footer_thai() {
		return pm_footer_thai;
	}

	public void setPm_footer_thai(String pm_footer_thai) {
		this.pm_footer_thai = pm_footer_thai;
	}

	public void setPm_footer(String pm_footer) {
		this.pm_footer = pm_footer;
	}

	public String getPm_addedon() {
		return pm_addedon;
	}

	public void setPm_addedon(String pm_addedon) {
		this.pm_addedon = pm_addedon;
	}

	public String getPm_updatedon() {
		return pm_updatedon;
	}

	public void setPm_updatedon(String pm_updatedon) {
		this.pm_updatedon = pm_updatedon;
	}
	public String getPm_remarks() {
		return pm_remarks;
	}

	public void setPm_remarks(String pm_remarks) {
		this.pm_remarks = pm_remarks;
	}

	public void setPm_id(Integer pm_id) {
		this.pm_id = pm_id;
	}

	@Override
	public String toString() {
		return "Portal [pm_id=" + pm_id + ", pm_name=" + pm_name + ", pm_logo=" + pm_logo + ", pm_title=" + pm_title
				+ ", pm_title_arabic=" + pm_title_arabic + ", pm_title_russian=" + pm_title_russian
				+ ", pm_title_french=" + pm_title_french + ", pm_title_italic=" + pm_title_italic + ", pm_title_greek="
				+ pm_title_greek + ", pm_title_thai=" + pm_title_thai + ", pm_footer=" + pm_footer
				+ ", pm_footer_arabic=" + pm_footer_arabic + ", pm_footer_russian=" + pm_footer_russian
				+ ", pm_footer_french=" + pm_footer_french + ", pm_footer_italic=" + pm_footer_italic
				+ ", pm_footer_greek=" + pm_footer_greek + ", pm_footer_thai=" + pm_footer_thai + ", pm_status="
				+ pm_status + ", pm_addedon=" + pm_addedon + ", pm_updatedon=" + pm_updatedon + ", pm_remarks="
				+ pm_remarks + "]";
	}

	

	

	
	
	
}

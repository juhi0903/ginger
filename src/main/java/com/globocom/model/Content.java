package com.globocom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content_data_master")
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String cdm_id;
	String cdm_ul_id;
	String cdm_ct_id;
	String cdm_cm_id;
	String cdm_title;
	String cdm_title_arabic = "";
	String cdm_title_russian = "";
	String cdm_title_french = "";
	String cdm_title_italic = "";
	String cdm_title_greek = "";
	String cdm_title_thai = "";
	String cdm_short_desc="";
	String cdm_long_desc="";
	String cdm_status = "UPLOADED";
	String cdm_live = "NO";
	String cdm_addedon;

	String cdm_updatedon;
	String cdm_licensed_till;
	String cdm_hosting = "LOCAL";
	String cdm_remarks ="";
	String cdm_album = "";
	String cdm_artist = "";
	String cdm_tags = "";
	String cdm_thumbnail_1 = "";
	String cdm_thumbnail_2 = "";
	String cdm_thumbnail_3 = "";
	String cdm_content_path;

	public String getCdm_id() {
		return cdm_id;
	}

	public void setCdm_id(String cdm_id) {
		this.cdm_id = cdm_id;
	}

	public String getCdm_ul_id() {
		return cdm_ul_id;
	}

	public void setCdm_ul_id(String cdm_ul_id) {
		this.cdm_ul_id = cdm_ul_id;
	}

	public String getCdm_ct_id() {
		return cdm_ct_id;
	}

	public void setCdm_ct_id(String cdm_ct_id) {
		this.cdm_ct_id = cdm_ct_id;
	}

	public String getCdm_cm_id() {
		return cdm_cm_id;
	}

	public void setCdm_cm_id(String cdm_cm_id) {
		this.cdm_cm_id = cdm_cm_id;
	}

	public String getCdm_title() {
		return cdm_title;
	}

	public void setCdm_title(String cdm_title) {
		this.cdm_title = cdm_title;
	}

	public String getCdm_title_arabic() {
		return cdm_title_arabic;
	}

	public void setCdm_title_arabic(String cdm_title_arabic) {
		this.cdm_title_arabic = cdm_title_arabic;
	}

	public String getCdm_title_russian() {
		return cdm_title_russian;
	}

	public void setCdm_title_russian(String cdm_title_russian) {
		this.cdm_title_russian = cdm_title_russian;
	}

	public String getCdm_title_french() {
		return cdm_title_french;
	}

	public void setCdm_title_french(String cdm_title_french) {
		this.cdm_title_french = cdm_title_french;
	}

	public String getCdm_title_italic() {
		return cdm_title_italic;
	}

	public void setCdm_title_italic(String cdm_title_italic) {
		this.cdm_title_italic = cdm_title_italic;
	}

	public String getCdm_title_greek() {
		return cdm_title_greek;
	}

	public void setCdm_title_greek(String cdm_title_greek) {
		this.cdm_title_greek = cdm_title_greek;
	}

	public String getCdm_title_thai() {
		return cdm_title_thai;
	}

	public void setCdm_title_thai(String cdm_title_thai) {
		this.cdm_title_thai = cdm_title_thai;
	}

	public String getCdm_short_desc() {
		return cdm_short_desc;
	}

	public void setCdm_short_desc(String cdm_short_desc) {
		this.cdm_short_desc = cdm_short_desc;
	}

	public String getCdm_long_desc() {
		return cdm_long_desc;
	}

	public void setCdm_long_desc(String cdm_long_desc) {
		this.cdm_long_desc = cdm_long_desc;
	}

	public String getCdm_status() {
		return cdm_status;
	}

	public void setCdm_status(String cdm_status) {
		this.cdm_status = cdm_status;
	}

	public String getCdm_live() {
		return cdm_live;
	}

	public void setCdm_live(String cdm_live) {
		this.cdm_live = cdm_live;
	}

	public String getCdm_addedon() {
		return cdm_addedon;
	}

	public void setCdm_addedon(String cdm_addedon) {
		this.cdm_addedon = cdm_addedon;
	}

	public String getCdm_updatedon() {
		return cdm_updatedon;
	}

	public void setCdm_updatedon(String cdm_updatedon) {
		this.cdm_updatedon = cdm_updatedon;
	}

	public String getCdm_licensed_till() {
		return cdm_licensed_till;
	}

	public void setCdm_licensed_till(String cdm_licensed_till) {
		this.cdm_licensed_till = cdm_licensed_till;
	}

	public String getCdm_hosting() {
		return cdm_hosting;
	}

	public void setCdm_hosting(String cdm_hosting) {
		this.cdm_hosting = cdm_hosting;
	}

	public String getCdm_remarks() {
		return cdm_remarks;
	}

	public void setCdm_remarks(String cdm_remarks) {
		this.cdm_remarks = cdm_remarks;
	}

	public String getCdm_album() {
		return cdm_album;
	}

	public void setCdm_album(String cdm_album) {
		this.cdm_album = cdm_album;
	}

	public String getCdm_artist() {
		return cdm_artist;
	}

	public void setCdm_artist(String cdm_artist) {
		this.cdm_artist = cdm_artist;
	}

	public String getCdm_tags() {
		return cdm_tags;
	}

	public void setCdm_tags(String cdm_tags) {
		this.cdm_tags = cdm_tags;
	}

	public String getCdm_thumbnail_1() {
		return cdm_thumbnail_1;
	}

	public void setCdm_thumbnail_1(String cdm_thumbnail_1) {
		this.cdm_thumbnail_1 = cdm_thumbnail_1;
	}

	public String getCdm_thumbnail_2() {
		return cdm_thumbnail_2;
	}

	public void setCdm_thumbnail_2(String cdm_thumbnail_2) {
		this.cdm_thumbnail_2 = cdm_thumbnail_2;
	}

	public String getCdm_thumbnail_3() {
		return cdm_thumbnail_3;
	}

	public void setCdm_thumbnail_3(String cdm_thumbnail_3) {
		this.cdm_thumbnail_3 = cdm_thumbnail_3;
	}

	public String getCdm_content_path() {
		return cdm_content_path;
	}

	public void setCdm_content_path(String cdm_content_path) {
		this.cdm_content_path = cdm_content_path;
	}

	@Override
	public String toString() {
		return "Content [cdm_id=" + cdm_id + ", cdm_ul_id=" + cdm_ul_id
				+ ", cdm_ct_id=" + cdm_ct_id + ", cdm_cm_id=" + cdm_cm_id
				+ ", cdm_title=" + cdm_title + ", cdm_title_arabic="
				+ cdm_title_arabic + ", cdm_title_russian=" + cdm_title_russian
				+ ", cdm_title_french=" + cdm_title_french
				+ ", cdm_title_italic=" + cdm_title_italic
				+ ", cdm_title_greek=" + cdm_title_greek + ", cdm_title_thai="
				+ cdm_title_thai + ", cdm_short_desc=" + cdm_short_desc
				+ ", cdm_long_desc=" + cdm_long_desc + ", cdm_status="
				+ cdm_status + ", cdm_live=" + cdm_live + ", cdm_addedon="
				+ cdm_addedon + ", cdm_updatedon=" + cdm_updatedon
				+ ", cdm_licensed_till=" + cdm_licensed_till + ", cdm_hosting="
				+ cdm_hosting + ", cdm_remarks=" + cdm_remarks + ", cdm_album="
				+ cdm_album + ", cdm_artist=" + cdm_artist + ", cdm_tags="
				+ cdm_tags + ", cdm_thumbnail_1=" + cdm_thumbnail_1
				+ ", cdm_thumbnail_2=" + cdm_thumbnail_2 + ", cdm_thumbnail_3="
				+ cdm_thumbnail_3 + ", cdm_content_path=" + cdm_content_path
				+ "]";
	}

}

package com.globocom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_login")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ul_id;
	
    private String ul_username;
	
    private String ul_email;
	
    private String ul_addedon;
	
    private String ul_updatedon;
    
    private String ul_user_role;
	
    private String ul_status;
	
    private String ul_phone;
	
    private String ul_password;
    
    private String ul_name;

	public long getUl_id() {
		return ul_id;
	}

	public void setUl_id(long ul_id) {
		this.ul_id = ul_id;
	}

	public String getUl_username() {
		return ul_username;
	}

	public void setUl_username(String ul_username) {
		this.ul_username = ul_username;
	}

	public String getUl_email() {
		return ul_email;
	}

	public void setUl_email(String ul_email) {
		this.ul_email = ul_email;
	}

	public String getUl_addedon() {
		return ul_addedon;
	}

	public void setUl_addedon(String ul_addedon) {
		this.ul_addedon = ul_addedon;
	}

	public String getUl_updatedon() {
		return ul_updatedon;
	}

	public void setUl_updatedon(String ul_updatedon) {
		this.ul_updatedon = ul_updatedon;
	}

	public String getUl_user_role() {
		return ul_user_role;
	}

	public void setUl_user_role(String ul_user_role) {
		this.ul_user_role = ul_user_role;
	}

	public String getUl_status() {
		return ul_status;
	}

	public void setUl_status(String ul_status) {
		this.ul_status = ul_status;
	}

	public String getUl_phone() {
		return ul_phone;
	}

	public void setUl_phone(String ul_phone) {
		this.ul_phone = ul_phone;
	}

	public String getUl_password() {
		return ul_password;
	}

	public void setUl_password(String ul_password) {
		this.ul_password = ul_password;
	}

	public String getUl_name() {
		return ul_name;
	}

	public void setUl_name(String ul_name) {
		this.ul_name = ul_name;
	}

	@Override
	public String toString() {
		return "User [ul_id=" + ul_id + ", ul_username=" + ul_username + ", ul_email=" + ul_email + ", ul_addedon="
				+ ul_addedon + ", ul_updatedon=" + ul_updatedon + ", ul_user_role=" + ul_user_role + ", ul_status="
				+ ul_status + ", ul_phone=" + ul_phone + ", ul_password=" + ul_password + ", ul_name=" + ul_name + "]";
	}
    
    

	
}
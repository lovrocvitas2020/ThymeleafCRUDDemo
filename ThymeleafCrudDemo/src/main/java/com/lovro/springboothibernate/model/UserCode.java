package com.lovro.springboothibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="USER_CODE")
@EntityListeners(AuditingEntityListener.class)
public class UserCode {
	
	
	public UserCode() {
		
	}
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int use_cod_id;
	
	private String use_code_name;
	
	private String use_code_desc;
	
	private String use_code_type;
	
	private String module_name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date user_lock;
	
	// getters and setters

	public int getUse_cod_id() {
		return use_cod_id;
	}

	public void setUse_cod_id(int use_cod_id) {
		this.use_cod_id = use_cod_id;
	}

	public String getUse_code_name() {
		return use_code_name;
	}

	public void setUse_code_name(String use_code_name) {
		this.use_code_name = use_code_name;
	}

	public String getUse_code_desc() {
		return use_code_desc;
	}

	public void setUse_code_desc(String use_code_desc) {
		this.use_code_desc = use_code_desc;
	}

	public String getUse_code_type() {
		return use_code_type;
	}

	public void setUse_code_type(String use_code_type) {
		this.use_code_type = use_code_type;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public Date getUser_lock() {
		return user_lock;
	}

	public void setUser_lock(Date user_lock) {
		this.user_lock = user_lock;
	}
	
	

}

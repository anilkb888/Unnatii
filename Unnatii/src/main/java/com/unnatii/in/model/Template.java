package com.unnatii.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import javax.persistence.OneToOne;

@Entity
@Table(name="Template")
public class Template {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="Name")
	private String name;
	

	@Column(name="Product_id")
	private int productCode;
	
	@Column(name="Template_file")
	private CommonsMultipartFile templateImage;
	
	@Column(name="Status")
	private String status;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getProductCode() {
		return productCode;
	}


	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}


	public CommonsMultipartFile getTemplateImage() {
		return templateImage;
	}


	public void setTemplateImage(CommonsMultipartFile templateImage) {
		this.templateImage = templateImage;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}

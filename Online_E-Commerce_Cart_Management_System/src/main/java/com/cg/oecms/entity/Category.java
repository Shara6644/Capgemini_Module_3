package com.cg.oecms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category_tbl")
public class Category {
	
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",sequenceName="product_category_seq",allocationSize=1)
	@Column(name="category_id")
	private int categoryId ;
	
	@Column(name="category_name",length=15)
	private String categoryName;
	
	
	
	
public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
    

public Category() {
	super();
}


@OneToMany(mappedBy="category")
@JsonIgnore
	private List<Product>  product=new ArrayList<>();
 

	


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", Product=" + product + "]";
	}


	
	
	
	
	

}

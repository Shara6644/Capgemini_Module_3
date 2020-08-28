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
@Table(name="retailer_tbl")
public class Retailer {
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_retailer_seq",allocationSize=1)
	
	@Column(name="retailer_id")
	private int retailerId;
	
	@Column(name="retailer_name")
	private String retailerName;
	
	@Column(name="retailer_location")
	private String retailerLocation;
	
	
	public Retailer(int retailerId, String retailerName, String retailerLocation) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.retailerLocation = retailerLocation;
	}
	

	public Retailer() {
		super();
	}


	@OneToMany(mappedBy="retailer")
	@JsonIgnore
	private List<Product>  product=new ArrayList<>();

	public int getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", retailerLocation="
				+ retailerLocation + ", Product=" + product + "]";
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerLocation() {
		return retailerLocation;
	}

	public void setRetailerLocation(String retailerLocation) {
		this.retailerLocation = retailerLocation;
	}


}














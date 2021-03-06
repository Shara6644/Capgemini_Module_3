package com.cg.oepms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="product_tbl")
public class Product {
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_seq",allocationSize=1)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name",length=15)
	private String productName;
	
	@Column(name="product_info",length=100)
	private String productInfo;
	
	

	@Column(name="product_price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category  category;
	
	@ManyToOne
	@JoinColumn(name="retailer_id")
	private Retailer  retailer;
	
//	@OneToMany(mappedBy="product")
//	@JsonIgnore
//	private List<Review>  Review=new ArrayList<Review>();
//	
	//@OneToMany(mappedBy="product")
	//@JsonIgnore
	//private List<Wishlist>  wishlist=new ArrayList<Wishlist>();	
    @OneToMany(mappedBy="product",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Cart>  cart=new ArrayList<Cart>();

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}
	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

//	public List<Review> getReview() {
//		return Review;
//	}
//
//	public void setReview(List<Review> review) {
//		Review = review;
//	}
//
//	public List<Wishlist> getWishlist() {
//		return wishlist;
//	}
//
//	public void setWishlist(List<Wishlist> wishlist) {
//		this.wishlist = wishlist;
//	}
//	
//	
//	
	
	
	
	

}

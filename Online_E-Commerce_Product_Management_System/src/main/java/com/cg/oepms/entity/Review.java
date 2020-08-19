package com.cg.oepms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="review_tbl")
public class Review {

	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_review_seq",allocationSize=1)
	@Column(name="review_id")

	private int reviewId;
	
	@Column(name="product_rating")
	private double  productRating;
	
	@Column(name="product_review",length=20)
	private String productReview;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product  product;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}

	public String getProductReview() {
		return productReview;
	}

	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
	
	
}

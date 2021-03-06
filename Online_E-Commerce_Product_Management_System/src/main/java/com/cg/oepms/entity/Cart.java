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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="cart_tbl")
public class Cart {
	
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_cart_seq",allocationSize=1)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private double totalPrice ;
	
	
	
	@ManyToOne 
	@JoinColumn(name="product_id")
	private Product product;
	

	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		
		this.totalPrice = totalPrice;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
	

}

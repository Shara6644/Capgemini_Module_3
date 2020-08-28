package com.cg.oecms.entity;

import java.time.LocalDate;



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
@Table(name="order_tbl")
public class Order {
	
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_order_seq",allocationSize=1)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="order_date")
	private LocalDate oderDate;
	
	@Column(name="contact")
	private long contact;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart  cart;


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOderDate() {
		return oderDate;
	}

	public void setOderDate(LocalDate oderDate) {
		this.oderDate = oderDate;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}


	

}

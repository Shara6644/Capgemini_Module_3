package com.cg.oecms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.oecms.dao.CartDao;
import com.cg.oecms.dao.CartDaoImpl;
import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Category;
import com.cg.oecms.entity.Product;
import com.cg.oecms.entity.Retailer;
import com.cg.oecms.exception.CartException;

public class CartDaoTest {
	
	Category category =null;
	Retailer retailer =null;
	Product product =null;
	Cart cart =null;
	
    
	
	@Autowired
	CartDao cartDao;
	
	@Test
	void findCartByCartId() throws CartException
	{
		 category =new Category();
		 retailer =new Retailer();
	 product =new Product();
		 cart =new Cart();
	category.setCategoryId(500);
	category.setCategoryName("Fashion");
	retailer.setRetailerId(200);
	retailer.setRetailerName("Apprio");
	retailer.setRetailerLocation("Hyderabad");
	product.setCategory(category);
	product.setRetailer(retailer);
	product.setProductInfo("abcd");
	product.setPrice(20000);
	product.setProductName("Fan");
	product.setProductId(111);
cart.setCartId(1023);
		cart.setProduct(product);
		cart.setQuantity(2);
		cart.setTotalPrice(cart.getQuantity()*cart.getProduct().getPrice());
	
		Cart cart =cartDao.findCartByCartId(2041);
		assertEquals(1023, cart.getCartId());
	}
		
		
		
	}
	
	

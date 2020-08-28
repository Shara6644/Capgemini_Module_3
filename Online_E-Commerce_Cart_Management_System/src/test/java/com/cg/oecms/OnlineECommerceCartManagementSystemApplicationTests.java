package com.cg.oecms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oecms.dao.CartDao;
import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Category;
import com.cg.oecms.entity.Product;
import com.cg.oecms.entity.Retailer;
import com.cg.oecms.exception.CartException;
import com.cg.oecms.service.CartService;

@SpringBootTest
class OnlineECommerceCartManagementSystemApplicationTests {

	
	@Autowired
	CartDao cartDao;
	@Autowired
	CartService cartService;
	
	@Test
	void testFindCartExistById() throws CartException
	{
		 Cart cart =cartDao.findCartByCartId(2061);
		 assertNotNull(cart);
		 
	}
	

@Test
	void testFindCartNotExist() throws CartException
	{

		assertThrows(CartException.class,()->cartDao.findCartByCartId(210));		 
	}
	
	@Test
	void testDeleteCartNotExistById() throws CartException
	{
		Cart cart =cartDao.deleteCartByCartId(1000);
	    assertNull(cart);
	}
	
	@Test
	void testDeleteCartNotExistByIdException() throws CartException
	{
		assertThrows(CartException.class,()->cartService.deleteCartByCartId(241));
	}
	
	@Test
	void testViewAllCarts() throws CartException
	{
		List<Cart> list= cartDao.viewAllCarts();
		assertTrue(list.size()>0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

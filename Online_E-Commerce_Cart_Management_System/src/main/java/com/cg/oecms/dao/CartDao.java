package com.cg.oecms.dao;

import java.util.List;

import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Product;
import com.cg.oecms.exception.CartException;
import com.cg.oecms.exception.ProductException;

public interface CartDao {
	 public List <Product> viewAllProducts() throws CartException;
	 
	 public Product findProductById(int productId) throws CartException;
	public List<Cart> viewAllCarts() throws CartException;
	
	public Cart findCartByCartId(int cartId) throws CartException;
	
	public Cart addProductToCart(Cart cart)throws CartException;
	
	public Cart deleteCartByCartId(int cartId) throws CartException;
	
	public Cart updateCart(Cart cart) throws CartException;
	
	
	
	
	
	

}

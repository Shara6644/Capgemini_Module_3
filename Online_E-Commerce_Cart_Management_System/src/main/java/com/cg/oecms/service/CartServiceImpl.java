package com.cg.oecms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oecms.dao.CartDao;
import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Product;
import com.cg.oecms.exception.CartException;
import com.cg.oecms.exception.ProductException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	@Override
	public List<Cart> viewAllCarts() throws CartException {
		List<Cart> cartList = cartDao.viewAllCarts();
		if(cartList.isEmpty())
		{
			throw new CartException("No Records Found");
		}
		
		return cartList ;
	}

	@Override
	public Cart addProductToCart(Cart cart) throws CartException {
		
	Product product =cartDao.findProductById(cart.getProduct().getProductId());
	if(product==null)
	{
		throw new CartException("Product Does not Exist");
	}
		double amt =cart.getQuantity()*cart.getProduct().getPrice();
		cart.setProduct(product);
		cart.setTotalPrice(amt);
          
		return cartDao.addProductToCart(cart);
	}

	@Override
	public Cart findCartByCartId(int cartId) throws CartException {
		
		return cartDao.findCartByCartId(cartId);
	}

	@Override
	public Cart deleteCartByCartId(int cartId) throws CartException {
	  Cart cart= cartDao.findCartByCartId(cartId);
	  
		if(cart==null)
		{
			throw new CartException ("No Cart Found");
		}
		
		return cartDao.deleteCartByCartId(cartId);
	}

	@Override
	public Cart updateCart(Cart cart) throws CartException {
		
		if( cartDao.findCartByCartId(cart.getCartId())!=null)
		 {
			Product product =cartDao.findProductById(cart.getProduct().getProductId());
			double amt =cart.getQuantity()*product.getPrice();
			cart.setProduct(product);
			cart.setTotalPrice(amt);
       cartDao.updateCart(cart); 
		 }
		 else
		 {
			 throw new CartException("Product does not exist");
		 }
		 return cart ;
		
	}

	@Override
	public List<Product> viewAllProducts() throws CartException {
		List<Product> listOfAllProducts = cartDao.viewAllProducts();
		if(listOfAllProducts.isEmpty())
		{
			throw new CartException("No Records Found");
		}
		
		return listOfAllProducts ;
		
	}

	@Override
	public Product findProductById(int productId) throws CartException {
	Product product =cartDao.findProductById(productId);
	if(product==null)
	{
		throw new CartException("No Product found with id "+productId);
	}
		return cartDao.findProductById(productId);
	}

}

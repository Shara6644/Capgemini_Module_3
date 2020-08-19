package com.cg.oecms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Product;
import com.cg.oecms.exception.CartException;
import com.cg.oecms.exception.ProductException;
@Repository
@Transactional
public class CartDaoImpl implements CartDao{

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Cart> viewAllCarts() throws CartException {
		String qry ="select c from Cart c";
		TypedQuery<Cart> query = entityManager.createQuery(qry, Cart.class);
		List<Cart> list = query.getResultList();
	
		
		
		
		return list;
	}
	@Override
	public Cart addProductToCart(Cart cart) throws CartException {
		
		entityManager.persist(cart);
		
		return cart;
	}
	@Override
	public Cart findCartByCartId(int cartId) throws CartException {
		Cart cart = entityManager.find(Cart.class,cartId);
		if(cart==null)
		{
			throw new CartException ("No Cart Found");
		}
		
		return cart;
	}
	@Override
	public Cart deleteCartByCartId(int cartId) throws CartException {
	
		Cart cart = entityManager.find(Cart.class, cartId);
		if(cart!=null)
		{
			entityManager.remove(cart);
		}
		return cart;
	}
	@Override
	public Cart updateCart(Cart cart) throws CartException {
	   
		
				 cart =entityManager.merge(cart);
		
		return cart;
	}
	@Override
	public List<Product> viewAllProducts() throws CartException {
		String qry ="select p from Product p";
		TypedQuery<Product> query = entityManager.createQuery(qry, Product.class);
		List<Product> listOfAllProducts = query.getResultList();
	
		
		
		
		return listOfAllProducts;
		
	}
	@Override
	public Product findProductById(int productId)throws CartException {
		Product product =entityManager.find(Product.class, productId);
		return product;
	}
	
	
	
}

package com.cg.oecms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Product;
import com.cg.oecms.exception.CartException;
import com.cg.oecms.exception.ProductException;
import com.cg.oecms.service.CartService;

@CrossOrigin("*")
@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("product")
	public ResponseEntity<List<Product>> findAllProducts() throws CartException {

		List<Product> listOfAllProducts = cartService.viewAllProducts();
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(listOfAllProducts, HttpStatus.OK);
		return responseEntity;

	}
	
	@GetMapping("cart")
	public ResponseEntity<List<Cart>> findAllCarts() throws CartException {

		List<Cart> list = cartService.viewAllCarts();
		ResponseEntity<List<Cart>> responseEntity = new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
		return responseEntity;

	}
	
	
	 @PostMapping("cart")
    public ResponseEntity<Cart> addproduct(@RequestBody Cart cart) throws CartException
    {
		 
		
    	Cart cart1 = cartService.addProductToCart(cart);
    	ResponseEntity<Cart> responseEntity = new ResponseEntity<Cart>(cart1,HttpStatus.OK);
    	return responseEntity;
    }
	 @PutMapping("cart")
		public ResponseEntity<Cart> updateCartItems(@RequestBody Cart cart ) throws CartException
		{
		 
			Cart cart1  = cartService.updateCart(cart);
			ResponseEntity<Cart>  responseEntity = new ResponseEntity<Cart>(cart1,HttpStatus.OK);
			return responseEntity;
		}
	    
	    @DeleteMapping("cart/{cid}")
		public ResponseEntity<Cart> deleteCartById(@PathVariable("cid") int cartId) throws CartException {

			

			Cart cart = cartService.deleteCartByCartId(cartId);
			ResponseEntity<Cart>  responseEntity = new ResponseEntity<Cart>(cart, HttpStatus.OK);

			return responseEntity;
		}
	    @GetMapping("cart/{cid}")
		public ResponseEntity<Cart> findCartById(@PathVariable("cid") int cartId) throws CartException {

			

			Cart cart = cartService.findCartByCartId(cartId);
			ResponseEntity<Cart>  responseEntity = new ResponseEntity<Cart>(cart, HttpStatus.OK);

			return responseEntity;
		}
	 
}

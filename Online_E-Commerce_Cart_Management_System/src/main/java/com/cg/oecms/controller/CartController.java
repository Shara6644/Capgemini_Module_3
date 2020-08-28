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
import org.springframework.web.client.RestTemplate;

import com.cg.oecms.entity.Cart;
import com.cg.oecms.entity.Login;
import com.cg.oecms.entity.Product;
import com.cg.oecms.entity.ProductList;
import com.cg.oecms.exception.CartException;

import com.cg.oecms.service.CartService;

@CrossOrigin("*")
@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	RestTemplate restTemplate ;
	
	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getAllProductList()
	{
		ResponseEntity<ProductList> productList = restTemplate.getForEntity("http://product-service/product",ProductList.class);
	List<Product> list = productList.getBody().getList();
	
	
	return  new ResponseEntity<>(list,HttpStatus.OK);
	}

	
	@GetMapping("/searchproducts/{pname}")
	public ResponseEntity<List<Product>> searchProductList(@PathVariable("pname") String productName)
	{
		ResponseEntity<ProductList> productList = restTemplate.getForEntity("http://product-service/product/name/"+productName,ProductList.class);
	List<Product> list = productList.getBody().getList();
	
	
	return  new ResponseEntity<>(list,HttpStatus.OK);
	}


	
	
	@GetMapping("cart/login/{user}/{pass}")
	public ResponseEntity<Login> login(@PathVariable("user") String user,@PathVariable("pass") String pass)
	{
		
		return restTemplate.getForEntity("http://login-service/login/validate/"+user+"/"+pass, Login.class); 
	}
	
	@PostMapping("cart/signup")
	public ResponseEntity<Login> signUp(@RequestBody Login login)
	{
		
		return restTemplate.postForEntity("http://login-service/login", login, Login.class); 
	}
	
	
	@GetMapping("cart")
	public ResponseEntity<List<Cart>> findAllCarts() throws CartException {

		List<Cart> list = cartService.viewAllCarts();
		
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	
	 @PostMapping("cart")
    public ResponseEntity<Cart> addproduct(@RequestBody Cart cart) throws CartException
    {
		 
		
    	Cart cart1 = cartService.addProductToCart(cart);
    	
    	return new ResponseEntity<>(cart1,HttpStatus.OK);
    }
	 @PutMapping("cart")
		public ResponseEntity<Cart> updateCartItems(@RequestBody Cart cart ) throws CartException
		{
		 
			Cart cart1  = cartService.updateCart(cart);
			
			return  new ResponseEntity<>(cart1,HttpStatus.OK);
		}
	    
	    @DeleteMapping("cart/{cid}")
		public ResponseEntity<Cart> deleteCartById(@PathVariable("cid") int cartId) throws CartException {

			

			Cart cart = cartService.deleteCartByCartId(cartId);
			

			return  new ResponseEntity<>(cart, HttpStatus.OK);
		}
	    @GetMapping("cart/{cid}")
		public ResponseEntity<Cart> findCartById(@PathVariable("cid") int cartId) throws CartException {

			

			Cart cart = cartService.findCartByCartId(cartId);
			

			return new ResponseEntity<>(cart, HttpStatus.OK);
		}
	 
}

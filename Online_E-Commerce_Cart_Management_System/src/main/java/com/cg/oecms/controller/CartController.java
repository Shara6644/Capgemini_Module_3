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
import com.cg.oecms.exception.ProductException;
import com.cg.oecms.service.CartService;

@CrossOrigin("*")
@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	RestTemplate restTemplate ;
	
	@GetMapping("cart/login/{user}/{pass}")
	public ResponseEntity<Login> login(@PathVariable("user") String user,@PathVariable("pass") String pass)
	{
		ResponseEntity<Login> re =restTemplate.getForEntity("http://login-service/login/validate/"+user+"/"+pass, Login.class);
		return re ;
	}
	
	@PostMapping("cart/signup")
	public ResponseEntity<Login> signUp(@RequestBody Login login)
	{
		ResponseEntity<Login> re =restTemplate.postForEntity("http://login-service/login", login, Login.class);
				//getForEntity("http://login-service/login", Login.class);
		return re ;
	}

	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getAllProductList()
	{
		ResponseEntity<ProductList> productList = restTemplate.getForEntity("http://product-service/product",ProductList.class);
	List<Product> list = productList.getBody().getList();
	
	ResponseEntity<List<Product>>  re= new ResponseEntity<>(list,HttpStatus.OK);
	return re;
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

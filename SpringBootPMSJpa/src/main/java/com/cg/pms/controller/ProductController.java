package com.cg.pms.controller;


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


import com.cg.pms.entity.Product;

import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
    @GetMapping("product/{pid}")
    public ResponseEntity<Product> findProductById(@PathVariable("pid") int productId) throws ProductException
    {
    	Product product = null;
    	
    	 product = productService.findProductById(productId);
    	ResponseEntity<Product> re = new ResponseEntity<Product>(product,HttpStatus.OK);
    	
    	return re;
    }
//    @ExceptionHandler(ProductException.class)
//    public ErrorInfo exeptionHandler(ProductException e ,HttpServletRequest request)
//    {
//    	ErrorInfo errorInfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),request.getRequestURI());
//    	return errorInfo;
//    }

    @PostMapping("product")
    public ResponseEntity<Product> addproduct(@RequestBody Product product) throws ProductException
    {
    	Product product1 = productService.createProduct(product);
    	ResponseEntity<Product> re = new ResponseEntity<Product>(product1,HttpStatus.OK);
    	return re;
    }
    
    @PutMapping("product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product ) throws ProductException
	{
		Product p  = productService.updateProduct(product);
		ResponseEntity<Product>  re = new ResponseEntity<Product>(p,HttpStatus.OK);
		return re;
	}
    
    @DeleteMapping("product/{pid}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("pid") int productId) throws ProductException {

		ResponseEntity<Product> rt = null;

		Product product = productService.deleteProductById(productId);
		rt = new ResponseEntity<Product>(product, HttpStatus.OK);

		return rt;
	}
    
    @GetMapping("product")
	public ResponseEntity<List<Product>> findAllProduct() throws ProductException {

		List<Product> list = productService.listAllProducts();
		ResponseEntity<List<Product>> rt = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		return rt;

	}
    @GetMapping("product/price/low/{low}/high/{high}")
	public ResponseEntity<List<Product>> findAllProducts(@PathVariable("low")double low ,@PathVariable("high") double high) throws ProductException {

		List<Product> list = productService.listOfProducts(low,high);
		ResponseEntity<List<Product>> rt = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		return rt;
    
    
}
}

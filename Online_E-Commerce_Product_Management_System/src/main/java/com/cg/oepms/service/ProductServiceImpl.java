package com.cg.oepms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.oepms.dao.ProductDao;
import com.cg.oepms.entity.Product;
import com.cg.oepms.exception.ProductException;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	@Override
	public Product findProductById(int productId) throws ProductException {
		
		Product product = productDao.findProductById(productId);
		
		if(product==null)
		{
			throw new ProductException(productId +" Product Id does not exists");
		}
		
		return product;
	}

	public Product createProduct(Product product) throws ProductException
	{
	 product=   productDao.createProduct(product);
		
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		if( productDao.findProductById(product.getProductId())!=null)
		 {
        productDao.updateProduct(product); 
		 }
		 else
		 {
			 throw new ProductException(product.getProductId()+"ID does not exist");
		 }
		 return product ;
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
  Product product = productDao.findProductById(productId);
   if(product==null)
   {
	   throw new ProductException(productId +" Product Id does not exists"); 
   }
		return productDao.deleteProductById(productId); 
	}

	@Override
	public List<Product> listAllProducts() throws ProductException
	{
		List<Product> list =productDao.listAllProducts();
		if(list.isEmpty())
		{
			throw new ProductException("No records found");
		}
		return list;
	}

	@Override
	public List<Product> listOfProducts(double low, double high) {
		
		return productDao.listOfProducts(low, high);
	}
}

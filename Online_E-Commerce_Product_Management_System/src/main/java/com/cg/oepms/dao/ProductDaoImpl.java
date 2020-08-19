package com.cg.oepms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.oepms.entity.Product;
import com.cg.oepms.exception.ProductException;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager em;
	@Override
	public Product findProductById(int productId) throws ProductException {
		Product product =em.find(Product.class, productId);
		return product;
	}

	@Override
	public Product createProduct(Product product) throws ProductException {
		em.persist(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		 Product p =em.merge(product);
		return p;
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		Product product = em.find(Product.class, productId);
		if(product!=null)
		{
			em.remove(product);
		}
		return product;
	}

	@Override
	public List<Product> listAllProducts() throws ProductException {
		String qry ="select p from Product p";
		TypedQuery<Product> query = em.createQuery(qry,Product.class );
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Product> listOfProducts(@Param ("low") double low,@Param("high") double high) {
		
		String qry = "select p from Product p where p.price>= :low and p.price<= :high";
		TypedQuery<Product> query = em.createQuery(qry,Product.class );
		query.setParameter("low", low).setParameter("high", high);

		List<Product> list = query.getResultList();
		return list;
	}
	

}

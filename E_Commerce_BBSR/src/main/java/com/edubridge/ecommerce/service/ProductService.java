package com.edubridge.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.ecommerce.dao.ProductDao;
import com.edubridge.ecommerce.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao ;
	
	public Product addNewProduct(Product product) {
		return productDao.save(product);
	}
	
	public List<Product> getAllProducts() {
		return (List<Product>)productDao.findAll();
	}
	
	public void deleteProductDetails(Integer productId) {
		productDao.deleteById(productId);
	}
	
	public Product getProductDetailsById(Integer productId) {
		return productDao.findById(productId).get();
	}
	
	public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer ProductId) {
		if(isSingleProductCheckout) {
			//we are going to buy a single product
			List<Product> list = new ArrayList<>();
			Product product = productDao.findById(ProductId).get();
			 list.add(product);
			 return list;
			
		}else
		{
			
		}
		
		return new ArrayList<>();
	}

}

package com.edubridge.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.edubridge.ecommerce.entity.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

}

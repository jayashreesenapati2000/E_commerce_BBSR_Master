package com.edubridge.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.edubridge.ecommerce.entity.OrderDetail;



public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer>{

}

package com.edubridge.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.ecommerce.configuration.JwtRequestFilter;
import com.edubridge.ecommerce.dao.OrderDetailDao;
import com.edubridge.ecommerce.dao.ProductDao;
import com.edubridge.ecommerce.dao.UserDao;
import com.edubridge.ecommerce.entity.OrderDetail;
import com.edubridge.ecommerce.entity.OrderInput;
import com.edubridge.ecommerce.entity.OrderProductQuantity;
import com.edubridge.ecommerce.entity.Product;
import com.edubridge.ecommerce.entity.User;

@Service
public class OrderDetailService{
	
	private static final String ORDER_PLACED="Placed";
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	public void placeOrder(OrderInput orderInput) {
		List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();
		for(OrderProductQuantity o: productQuantityList) {
			
			Product product = productDao.findById(o.getProductId()).get();			
			String currentUser = JwtRequestFilter.CURRENT_USER;
			User user = userDao.findById(currentUser).get();
			
			OrderDetail orderDetail = new OrderDetail(
					orderInput.getFullName(),
					orderInput.getFullAddress(),
					orderInput.getContactNumber(),
					orderInput.getAlternateContactNumber(),
					ORDER_PLACED,
					product.getProductDiscountedPrice() * o.getQuantity(),
					product,
					user				
					);
			
			orderDetailDao.save(orderDetail);
		}
	}

}

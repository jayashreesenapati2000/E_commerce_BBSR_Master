package com.edubridge.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.ecommerce.entity.OrderInput;
import com.edubridge.ecommerce.service.OrderDetailService;
import com.edubridge.ecommerce.service.ProductService;

@RestController
public class OrderDetailController {
	
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@PreAuthorize("hasRole('User')")
	@PostMapping({"/placeOrder"})
	public void placeOrder(@RequestBody OrderInput orderInput) {
		orderDetailService.placeOrder(orderInput);
	}

}

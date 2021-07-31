package com.Inventorymanagementservice.Paytmmall.controller;

import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.exception.QuantityNotGreaterThanZeroException;
import com.Inventorymanagementservice.Paytmmall.entity.Order;
import com.Inventorymanagementservice.Paytmmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @PostMapping("/customer/{customerId}/product/{productId}/quantity/{quantity}/order")
    public Order saveOrderDetails(@Valid @RequestBody Order order,
                                  @PathVariable("customerId") Long customerId,
                                  @PathVariable("productId") String productId,
                                  @PathVariable("quantity") Long quantity) throws ProductNotFoundException, QuantityNotGreaterThanZeroException {
        return orderService.saveOrderDetails(order,customerId,productId,quantity);
    }
}

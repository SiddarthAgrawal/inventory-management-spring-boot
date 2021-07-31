package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.exception.QuantityNotGreaterThanZeroException;
import com.Inventorymanagementservice.Paytmmall.entity.Order;

public interface OrderService {
    public Order saveOrderDetails(Order order,
                                  Long customerId,
                                  String productId,
                                  Long quantity) throws ProductNotFoundException, QuantityNotGreaterThanZeroException;
}

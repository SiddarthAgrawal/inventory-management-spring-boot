package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.entity.Customer;
import com.Inventorymanagementservice.Paytmmall.entity.Order;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomerDetails(Customer customer);

    public List<Order> getCustomerOrderDetail(Long customerId);
}

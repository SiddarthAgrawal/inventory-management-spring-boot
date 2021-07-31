package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.entity.Customer;
import com.Inventorymanagementservice.Paytmmall.entity.Order;
import com.Inventorymanagementservice.Paytmmall.repository.CustomerRepository;
import com.Inventorymanagementservice.Paytmmall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Customer saveCustomerDetails(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Order> getCustomerOrderDetail(Long customerId)
    {
        return orderRepository.findAllByCustomerId(customerId);
    }
}

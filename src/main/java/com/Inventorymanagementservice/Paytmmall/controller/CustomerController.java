package com.Inventorymanagementservice.Paytmmall.controller;

import com.Inventorymanagementservice.Paytmmall.entity.Customer;
import com.Inventorymanagementservice.Paytmmall.entity.Order;
import com.Inventorymanagementservice.Paytmmall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {


    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/saveCustomer")
    public Customer saveCustomerDetails(@Valid @RequestBody Customer customer)
    {
        return customerService.saveCustomerDetails(customer);
    }

    @GetMapping("/customer/{customerId}/orders")
    public List<Order> getCustomerOrdersDetail(@PathVariable("customerId") Long customerId)
    {
        return customerService.getCustomerOrderDetail(customerId);
    }
}

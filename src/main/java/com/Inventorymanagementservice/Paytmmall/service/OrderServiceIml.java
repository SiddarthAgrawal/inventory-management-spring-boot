package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.exception.QuantityNotGreaterThanZeroException;
import com.Inventorymanagementservice.Paytmmall.entity.Customer;
import com.Inventorymanagementservice.Paytmmall.entity.Order;
import com.Inventorymanagementservice.Paytmmall.repository.CustomerRepository;
import com.Inventorymanagementservice.Paytmmall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceIml implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ProductService productService;

    @Autowired
    public OrderServiceIml(OrderRepository orderRepository,
                           CustomerRepository customerRepository,
                           ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productService = productService;
    }




    @Override
    public Order saveOrderDetails(Order order,
                                  Long customerId,
                                  String productId,
                                  Long quantity)
            throws ProductNotFoundException, QuantityNotGreaterThanZeroException {
        Customer customer = customerRepository.findById(customerId).get();
        //TODO exceptional handling of customer presence
        order.setCustomer(customer);
        order.setProductId(productId);
        order.setQuantity(quantity);
//        String productId = order.getProductId();
//        Long quantity = order.getQuantity();
        productService.updateProductQuantityByDeletingItem(productId,quantity);
        return orderRepository.save(order);
    }
}

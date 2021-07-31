package com.Inventorymanagementservice.Paytmmall.repository;


import com.Inventorymanagementservice.Paytmmall.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer,Long> {
}

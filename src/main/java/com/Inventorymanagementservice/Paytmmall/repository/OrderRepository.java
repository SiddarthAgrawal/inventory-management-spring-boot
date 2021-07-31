package com.Inventorymanagementservice.Paytmmall.repository;

import com.Inventorymanagementservice.Paytmmall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository
        extends JpaRepository<Order,Long> {
//    @Query("SELECT " +
//            "orderId, quantity, productId, customer.customerId " +
//            "from Order where customer.customerId = ?1")
    //@Query(value = "select * from orders where customer.customer_id = ?1",nativeQuery = true)
    @Query("SELECT o from Order o where o.customer.customerId = ?1")
    List<Order> findAllByCustomerId(Long customerId);
}

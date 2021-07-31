package com.Inventorymanagementservice.Paytmmall.repository;

import com.Inventorymanagementservice.Paytmmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface ProductRepository extends
        JpaRepository<Product,Long> {

    //public Product findByitemNameIgnoreCase(String productid);

    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    public Product findByproductId(String productId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select i from Product i where i.productId = ?1")
    Product findByproductIdWithPessimisticLock(String productId);
}
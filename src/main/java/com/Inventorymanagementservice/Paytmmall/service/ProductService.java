package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.dto.ProductDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDtoExtension;
import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.exception.QuantityNotGreaterThanZeroException;

import java.util.List;

public interface ProductService {
    public ProductDtoExtension saveProductDetail(ProductDto productDto);

    public List<ProductDtoExtension> getAllProductDetail();

    public ProductDto getProductDetailByProductId(String productId) throws ProductNotFoundException;

    public ProductDto updateProductQuantityByDeletingItem(String productId, Long itemQuantity) throws QuantityNotGreaterThanZeroException, ProductNotFoundException;

    public ProductDtoExtension updateProductDetailByProductId(String productId, ProductDto productDto);

    public  ProductDto updateProductQuantityByAddItem(String productId, Long itemQuantity) throws ProductNotFoundException;

    }

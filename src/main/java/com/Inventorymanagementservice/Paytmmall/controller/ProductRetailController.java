package com.Inventorymanagementservice.Paytmmall.controller;


import com.Inventorymanagementservice.Paytmmall.converter.ConvertForDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDto;
import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.exception.QuantityNotGreaterThanZeroException;
import com.Inventorymanagementservice.Paytmmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRetailController {

    private ProductService productService;
    //private ConvertForDto convertForDto;
    //private Object ProductDto;

    @Autowired
    public ProductRetailController(ProductService productService, ConvertForDto convertForDto) {
        this.productService = productService;
        //this.convertForDto = convertForDto;
    }

    @PatchMapping("/product/{productId}/subtract/{itemQuantity}")
    public ProductDto addItemQuantity(@PathVariable String productId,
                                      @PathVariable Long itemQuantity)
            throws ProductNotFoundException, QuantityNotGreaterThanZeroException {

        return productService.updateProductQuantityByDeletingItem(productId,itemQuantity);
    }

    @PatchMapping("/product/{productId}/add/{itemQuantity}")
    public ProductDto subItemQuantity(@PathVariable String productId,
                                      @PathVariable Long itemQuantity)
            throws ProductNotFoundException, QuantityNotGreaterThanZeroException {

        return productService.updateProductQuantityByAddItem(productId,itemQuantity);
    }

}














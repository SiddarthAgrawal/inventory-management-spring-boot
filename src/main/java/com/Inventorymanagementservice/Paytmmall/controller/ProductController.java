
package com.Inventorymanagementservice.Paytmmall.controller;


import com.Inventorymanagementservice.Paytmmall.converter.ConvertForDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDtoExtension;
import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @PostMapping("/product")
    public ProductDtoExtension saveProductDetail(@Valid @RequestBody ProductDto productDto)
    {
        return productService.saveProductDetail(productDto);
    }

    @GetMapping("/product")
    public List<ProductDtoExtension> getAllProductDetail()
    {
        return productService.getAllProductDetail();
    }

    @GetMapping("/product/{productId}")
    public ProductDto getProductDetailById(@PathVariable("productId") String productId)
            throws ProductNotFoundException {

        return productService.getProductDetailByProductId(productId);
    }

    @PatchMapping("/product/update/{productId}")
    public ProductDtoExtension updateByProductId(@PathVariable("productId") String productId,
                                                 @RequestBody ProductDto productDto)
    {
        return productService.updateProductDetailByProductId(productId,productDto);
    }
}

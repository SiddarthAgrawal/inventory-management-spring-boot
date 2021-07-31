package com.Inventorymanagementservice.Paytmmall.converter;


import com.Inventorymanagementservice.Paytmmall.dto.ProductDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDtoExtension;
import com.Inventorymanagementservice.Paytmmall.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertForDto {

    public ProductDto productToProductDto(Product product)
    {
        ProductDto productDto = new ProductDto();
        productDto.setItemDescription(product.getItemDescription());
        productDto.setItemName(product.getItemName());
        productDto.setItemPrice(product.getItemPrice());
        productDto.setItemImageUrl(product.getItemImageUrl());
        productDto.setItemQuantity(product.getItemQuantity());
        return productDto;
    }

    public List<ProductDto> productToProductDto(List<Product> product)
    {
        return product.stream().map(p -> productToProductDto(p)).collect(Collectors.toList());

    }

    public Product productDtoToProduct(ProductDto productDto)
    {
        Product product = new Product();
        product.setItemDescription(productDto.getItemDescription());
        product.setItemName(productDto.getItemName());
        product.setItemPrice(productDto.getItemPrice());
        product.setItemImageUrl(productDto.getItemImageUrl());
        product.setItemQuantity(productDto.getItemQuantity());
        return product;
    }

    public List<Product> productDtoToProduct(List<ProductDto> productDto)
    {
        return productDto.stream().map(p -> productDtoToProduct(p)).collect(Collectors.toList());
    }


    public ProductDtoExtension productToProductDtoExtension(Product product)
    {
        ProductDtoExtension productDtoExtension = new ProductDtoExtension();
        productDtoExtension.setItemDescription(product.getItemDescription());
        productDtoExtension.setItemName(product.getItemName());
        productDtoExtension.setItemPrice(product.getItemPrice());
        productDtoExtension.setItemImageUrl(product.getItemImageUrl());
        productDtoExtension.setItemQuantity(product.getItemQuantity());
        productDtoExtension.setProductId(product.getProductId());
        return productDtoExtension;
    }

    public List<ProductDtoExtension> productToProductDtoExtension(List<Product> product)
    {

        return product.stream().map(p->productToProductDtoExtension(p)).collect(Collectors.toList());
    }

}

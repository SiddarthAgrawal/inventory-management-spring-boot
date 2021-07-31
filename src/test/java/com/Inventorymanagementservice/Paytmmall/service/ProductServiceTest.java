package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.converter.ConvertForDto;
import com.Inventorymanagementservice.Paytmmall.entity.Product;
import com.Inventorymanagementservice.Paytmmall.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ConvertForDto convertForDto;

    @MockBean
    private ProductRepository productRepository;


    @BeforeEach
    void setUp() {
        Product product = Product.builder()
                            .productId("this is product id")
                            .itemName("T-shirt")
                            .itemDescription("For Men's")
                            .itemPrice(Double.valueOf(200))
                            .itemImageUrl("image Url")
                            .itemId(1L)
                            .itemQuantity(Long.valueOf(20))
                            .build();

        Mockito.when(productRepository.findByproductId("this is product id"))
                .thenReturn(product);


        Mockito.when(productRepository.save(product))
                .thenReturn(product);

        List<Product> Products = Arrays.asList(product);
        Mockito.when(productRepository.findAll()).thenReturn(Products);



    }

    @Test
    public void testWhenGetProductById()
    {
        String productId = "this is product id";
        Product found = productRepository.findByproductId(productId);
        assertEquals(productId,found.getProductId());
    }

    @Test
    public void testSave()
    {
        Product product = new Product();
        product.setItemName("T-shirt");
        product.setItemDescription("For Men's");
        product.setItemImageUrl("image Url");
        product.setItemPrice(Double.valueOf(200));
        product.setItemQuantity(Long.valueOf(20));
        product.setProductId("this is product id");
        product.setItemId(1L);

        assertEquals(product,productRepository.save(product));
    }

    @Test
    public void testWhenGetAllProduct()
    {
        Product product = Product.builder()
                .productId("this is product id")
                .itemName("T-shirt")
                .itemDescription("For Men's")
                .itemPrice(Double.valueOf(200))
                .itemImageUrl("image Url")
                .itemId(1L)
                .itemQuantity(Long.valueOf(20))
                .build();
        List<Product> p = Arrays.asList(product);
        assertEquals(p,productRepository.findAll());
    }

    @Test
    public void testUpdateProductQuantityByDeletingItem()
    {
        Product product = Product.builder()
                .productId("this is product id")
                .itemName("T-shirt")
                .itemDescription("For Men's")
                .itemPrice(Double.valueOf(200))
                .itemImageUrl("image Url")
                .itemId(1L)
                .itemQuantity(Long.valueOf(15))
                .build();
        Product p = productRepository.findByproductId("this is product id");
        p.setItemQuantity(Long.valueOf(15));
        productRepository.save(p);
        assertEquals(product.getItemQuantity(),productRepository.findByproductId("this is product id").getItemQuantity());
    }

}
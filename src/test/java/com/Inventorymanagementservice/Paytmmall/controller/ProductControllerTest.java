package com.Inventorymanagementservice.Paytmmall.controller;

import com.Inventorymanagementservice.Paytmmall.converter.ConvertForDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDtoExtension;
import com.Inventorymanagementservice.Paytmmall.entity.Product;
import com.Inventorymanagementservice.Paytmmall.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockmv;

    @MockBean
    private ProductService productService;


    @MockBean
    private ConvertForDto convertForDto;

    private Product p;
    private ProductDtoExtension productDtoExtension;

    @BeforeEach
    void setUp() {
        productDtoExtension = ProductDtoExtension.builder()
                .productId("this is id")
                .itemName("T-shirt")
                .itemDescription("For Men's")
                .itemPrice(Double.valueOf(200))
                .itemImageUrl("image Url")
                .itemQuantity(Long.valueOf(20))
                .build();

    }

    @Test
    void saveProductDetail() throws Exception {
        ProductDto inputProduct = ProductDto.builder()
                .itemName("T-shirt")
                .itemDescription("For Men's")
                .itemPrice(Double.valueOf(200))
                .itemImageUrl("image Url")
                .itemQuantity(Long.valueOf(20))
                .build();
        Mockito.when(productService.saveProductDetail(ArgumentMatchers.any(ProductDto.class))).thenReturn(productDtoExtension);
        mockmv.perform(post("/product")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "    \"itemName\":\"T-shirt\",\n" +
                "    \"itemDescription\":\"For Men's\",\n" +
                "    \"itemPrice\":200,\n" +
                "    \"itemQuantity\":\"20\",\n" +
                "    \"itemImageUrl\": \"image url\"\n" +
                "}")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{}"));

    }

    @Test
    void getProductDetailById() {
    }
}
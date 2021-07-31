package com.Inventorymanagementservice.Paytmmall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoExtension{
    private String productId;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private Long itemQuantity;
    private String itemImageUrl;
}

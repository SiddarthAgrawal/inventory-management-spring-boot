package com.Inventorymanagementservice.Paytmmall.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "inventory")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long itemId;
    //@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Lon

//    @Id
//    @SequenceGenerator(name = "inventory"
//                    ,sequenceName="inventory"
//                    ,allocationSize = 50
//                    ,initialValue = 10000)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE
//                    ,generator = "inventory")
//    @Column(name = "id")
//    private Long itemId;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type="uuid-char")
//    @Column(name="product_id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
//    private String productId;


//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type="uuid-char")
    @Column(name="product_id")
    private String productId;


    @NotNull(message = "please provide the item name")
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @NotNull(message = "please provide the price of item")
    @Column(name = "item_price")
    private Double itemPrice;

    @NotNull(message = "provide the quantity of the item")
    @Column(name = "item_quantity")
    private Long itemQuantity;

    @Column(name = "item_image_url")
    private String itemImageUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updateDate;

    @PrePersist
    public void prePersist()
    {
        if(this.productId == null)
            this.productId = UUID.randomUUID().toString();
    }
}

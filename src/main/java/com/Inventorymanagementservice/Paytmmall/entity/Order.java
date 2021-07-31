package com.Inventorymanagementservice.Paytmmall.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//            name = "sequence-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @Parameter(name = "sequence_name", value = "user_sequence"),
//                    @Parameter(name = "initial_value", value = "100001"),
//                    @Parameter(name = "increment_size", value = "1")
//            }
//    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "product_id")
    private String productId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdDate;


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customer_id"
    )
    private Customer customer;

}

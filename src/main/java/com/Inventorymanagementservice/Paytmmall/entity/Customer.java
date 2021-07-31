package com.Inventorymanagementservice.Paytmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull(message = "please enter your First Name!!")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Size(min = 10,max = 10,message = "Enter valid mobile number!!")
    @NotNull(message = "Enter your Mobile Number!!")
    @Column(name = "phone_number")
    private String phoneNumber;

}

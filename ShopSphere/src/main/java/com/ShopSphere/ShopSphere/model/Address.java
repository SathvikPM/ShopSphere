package com.ShopSphere.ShopSphere.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
     private String pincode;
     private String type;

}

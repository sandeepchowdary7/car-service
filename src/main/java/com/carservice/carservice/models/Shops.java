package com.carservice.carservice.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
@Data
public class Shops extends AuditModel {

    @GeneratedValue
    @Id
    private int id;

    private String shop_reg_id;
    private String name;
    private String country;
    private String state;
    private String city;
    private String street_address;
    private String zipcode;
    private String phone_number;
    private String secondary_phone_number;
    private String email;
}

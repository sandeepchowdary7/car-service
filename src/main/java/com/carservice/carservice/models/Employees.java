package com.carservice.carservice.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Employees extends AuditModel {

    @GeneratedValue
    @Id
    private int id;

    private String first_name;
    private String last_name;
    private String middle_name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phone_umber;
    private String secondary_phone_number;
    private String gender;
    private String role;
    private Date dob;

    private String address1_country;
    private String address1_state;
    private String address1_city;
    private String address1_zipcode;
    private String address1_street_address;

    private String address2_country;
    private String address2_state;
    private String address2_city;
    private String address2_zipcode;
    private String address2_street_address;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Shops shops;
}

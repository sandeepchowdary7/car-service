package com.carservice.carservice.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Products extends AuditModel {

    @GeneratedValue
    @Id
    private int id;

    private String name;
    private String description;
    private String code;
    private String availability;
    private String stock;
}

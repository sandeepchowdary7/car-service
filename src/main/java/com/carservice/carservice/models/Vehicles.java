package com.carservice.carservice.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
@Data
public class Vehicles extends AuditModel {

    @GeneratedValue
    @Id
    private int id;

    private String brand;
    private String model;
    private String year;
    private String color;
    private String transmission;
    private String fuel_type;
    private String mileage;
    private String tag;
    private String registered_state;
    private String other;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Clients clients;
}

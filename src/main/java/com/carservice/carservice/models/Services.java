package com.carservice.carservice.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Services extends AuditModel {

    @GeneratedValue
    @Id
    private int id;

    private String type;
    private String notes;
    private String status;

    private Date serviced_at;
    private Date returned_at;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Vehicles vehicles;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employees employees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "price_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Prices prices;
}

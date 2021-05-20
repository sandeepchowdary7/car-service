package com.carservice.carservice.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Calendar extends AuditModel{

    @GeneratedValue
    @Id
    private int id;

    private String availability;
    private Date Date;
    private String slot1;
    private String slot2;
    private String slot3;
    private String slot4;
    private String slot5;
    private String slot6;
    private String slot7;
}

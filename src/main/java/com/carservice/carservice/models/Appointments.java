package com.carservice.carservice.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Appointments extends AuditModel{

    @GeneratedValue
    @Id
    private int id;


    @ManyToMany
    @JoinTable(
            name = "appointments_vehicle",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Vehicles> vehicles;


    @ManyToMany
    @JoinTable(
            name = "appointments_vehicle",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Employees> employees;

    @ManyToMany
    @JoinTable(
            name = "appointments_vehicle",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Schedules> schedules;

    @ManyToMany
    @JoinTable(
            name = "appointments_vehicle",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Services> services;

    @ManyToMany
    @JoinTable(
            name = "appointments_vehicle",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Calendar> calendars;
}
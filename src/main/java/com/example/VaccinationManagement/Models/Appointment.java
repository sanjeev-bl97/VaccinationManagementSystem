package com.example.VaccinationManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date appointmentDate;

    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Doctor doctor;

}

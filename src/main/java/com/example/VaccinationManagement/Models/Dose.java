package com.example.VaccinationManagement.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "dose")
@Data
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String doseId;

    @CreationTimestamp
    private Date vaccinationDate;

    @OneToOne
    @JoinColumn
    private User user;
}

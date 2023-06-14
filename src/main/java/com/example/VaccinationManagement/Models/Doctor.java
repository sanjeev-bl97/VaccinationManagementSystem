package com.example.VaccinationManagement.Models;

import com.example.VaccinationManagement.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;

    @Column(name = "user_name")
    private String name;

    @Column(unique = true)
    private String emailId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;


    @ManyToOne
    @JoinColumn
    private VaccinationCenter vaccinationCenter;




    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Appointment> appoinmentsList = new ArrayList<>();


}

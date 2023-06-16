package com.example.VaccinationManagement.Models;

import com.example.VaccinationManagement.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String name;

    @Column(unique = true)
    private String emailId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private String mobileNo;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private Dose dose;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointmentList = new ArrayList();

}

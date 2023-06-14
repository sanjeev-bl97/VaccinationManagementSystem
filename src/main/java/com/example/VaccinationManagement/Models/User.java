package com.example.VaccinationManagement.Models;

import com.example.VaccinationManagement.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

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
    private Dose dose;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

}

package com.example.VaccinationManagement.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccination_center")
@Data
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String centerName;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private int doseCapacity;

    @OneToMany(mappedBy = "vaccinationCenter",cascade = CascadeType.ALL)
    private List<Doctor> doctorsArrayList = new ArrayList<>();


}

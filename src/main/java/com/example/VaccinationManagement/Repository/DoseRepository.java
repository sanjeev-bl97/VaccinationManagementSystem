package com.example.VaccinationManagement.Repository;

import com.example.VaccinationManagement.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {

}

package com.example.VaccinationManagement.Controllers;

import com.example.VaccinationManagement.Dtos.AssociateDocDto;
import com.example.VaccinationManagement.Models.Doctor;
import com.example.VaccinationManagement.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
        try{
            String message = doctorService.addDoctor(doctor);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/associateDocCenter")
    public ResponseEntity<String> associateDocCenter(@RequestBody AssociateDocDto associateDocDto){
        try{
            String message = doctorService.associateDocCenter(associateDocDto);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}

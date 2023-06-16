package com.example.VaccinationManagement.Controllers;


import com.example.VaccinationManagement.Models.Doctor;
import com.example.VaccinationManagement.Models.VaccinationCenter;
import com.example.VaccinationManagement.Services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")


public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/addCenter")
    public ResponseEntity<String> addCenter(@RequestBody VaccinationCenter vaccinationCenter){
        try{
            String message = vaccinationCenterService.addCenter(vaccinationCenter);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allDoctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam int centerId){
        try{
            List<Doctor> message = vaccinationCenterService.getAllDoctors(centerId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

}

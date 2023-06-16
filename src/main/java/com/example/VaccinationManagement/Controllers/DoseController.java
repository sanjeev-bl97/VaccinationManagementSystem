package com.example.VaccinationManagement.Controllers;

import com.example.VaccinationManagement.Services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("/giveDose")
    public ResponseEntity<String> giveDose(@RequestParam("doseId")String doseId, @RequestParam("userId")Integer userId){

        try{
            String message = doseService.giveDose(doseId,userId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

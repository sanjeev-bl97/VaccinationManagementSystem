package com.example.VaccinationManagement.Controllers;

import com.example.VaccinationManagement.Dtos.AppointmentReqDto;
import com.example.VaccinationManagement.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    public String bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto){

        try{
            String message = appointmentService.bookAppointment(appointmentReqDto);
            return message;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

}

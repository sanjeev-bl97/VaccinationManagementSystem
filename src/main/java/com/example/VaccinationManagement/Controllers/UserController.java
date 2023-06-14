package com.example.VaccinationManagement.Controllers;


import com.example.VaccinationManagement.Dtos.UpdateEmailDto;
import com.example.VaccinationManagement.Models.User;
import com.example.VaccinationManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);


    }

    @GetMapping("/getVaccinationDate")
    public Date getVaccinationDate(@RequestParam("userId") Integer userId){
        return userService.getVaccinationDate(userId);
    }

    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return userService.updateEmail(updateEmailDto);
    }

    @GetMapping("/getByEmailId/{emailId}")
    public User getByEmailId(@PathVariable String emailId){
        return userService.getByEmailId(emailId);
    }

}

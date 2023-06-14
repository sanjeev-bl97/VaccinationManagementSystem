package com.example.VaccinationManagement.Services;
import com.example.VaccinationManagement.Dtos.UpdateEmailDto;
import com.example.VaccinationManagement.Models.Dose;
import com.example.VaccinationManagement.Models.User;
import com.example.VaccinationManagement.Repository.DoseRepository;
import com.example.VaccinationManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

   @Autowired
   UserRepository userRepository;


    public User addUser(User user) {

        user = userRepository.save(user);

        return user;

    }

    public Date getVaccinationDate(Integer userId) {
        User user = userRepository.findById(userId).get();
        Dose dose = user.getDose();

        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userId = updateEmailDto.getUserId();
        User user = userRepository.findById(userId).get();

        user.setEmailId(updateEmailDto.getNewEmailId());

        userRepository.save(user);

        return "Email updated Successfully";

    }

    public User getByEmailId(String emailId) {

        return userRepository.findByEmailId(emailId);

    }

}

package com.example.VaccinationManagement.Services;

import com.example.VaccinationManagement.Exceptions.UserNotFound;
import com.example.VaccinationManagement.Models.Dose;
import com.example.VaccinationManagement.Models.User;
import com.example.VaccinationManagement.Repository.DoseRepository;
import com.example.VaccinationManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseId, Integer userId) throws UserNotFound {
        User user = userRepository.findById(userId).get();

        if(user == null)
            throw new UserNotFound("User Not Found ");

        Dose dose = new Dose();
        dose.setDoseId(doseId);
        dose.setUser(user);

        user.setDose(dose);
        userRepository.save(user);


        return "Dose given to user successfully";
    }

}

package com.example.VaccinationManagement.Services;
import com.example.VaccinationManagement.Exceptions.VaccinationAddressNotFound;
import com.example.VaccinationManagement.Models.Doctor;
import com.example.VaccinationManagement.Models.VaccinationCenter;
import com.example.VaccinationManagement.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;


    public String addCenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {

        if(vaccinationCenter.getAddress() == null){
            throw new VaccinationAddressNotFound("VaccinationAddress Not Found");
        }


        vaccinationCenterRepository.save(vaccinationCenter);
        return "VaccinationCenter added successfully at "+vaccinationCenter.getAddress();
    }

    public List<Doctor> getAllDoctors(int centerId) {



        return vaccinationCenterRepository.findById(centerId).get().getDoctorsArrayList();
    }

}

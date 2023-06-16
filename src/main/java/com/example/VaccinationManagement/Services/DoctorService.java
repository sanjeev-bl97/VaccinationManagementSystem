package com.example.VaccinationManagement.Services;
import com.example.VaccinationManagement.Dtos.AssociateDocDto;
import com.example.VaccinationManagement.Exceptions.DoctorAlreadyExists;
import com.example.VaccinationManagement.Exceptions.DoctorNotFound;
import com.example.VaccinationManagement.Exceptions.EmailIdEmpty;
import com.example.VaccinationManagement.Exceptions.VaccinationAddressNotFound;
import com.example.VaccinationManagement.Models.Doctor;
import com.example.VaccinationManagement.Models.VaccinationCenter;
import com.example.VaccinationManagement.Repository.DoctorRepository;
import com.example.VaccinationManagement.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addDoctor(Doctor doctor) throws EmailIdEmpty, DoctorAlreadyExists {

        if(doctor.getEmailId() == null){
            throw new EmailIdEmpty("EmailId is mandatory");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId()) != null){
            throw new DoctorAlreadyExists("Doctor with "+doctor.getEmailId()+"is already present");
        }

        doctorRepository.save(doctor);
        return "Doctor added successfully";

    }

    public String associateDocCenter(AssociateDocDto associateDocDto) throws DoctorNotFound, VaccinationAddressNotFound {

        Optional<Doctor> doctorOptional = doctorRepository.findById(associateDocDto.getDocId());
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(associateDocDto.getCenterId());

        if(doctorOptional.isEmpty())
            throw new DoctorNotFound("Doctor not found");
        if(vaccinationCenterOptional.isEmpty())
            throw new VaccinationAddressNotFound("VaccinationCenter not found");

        Doctor doctor = doctorOptional.get();
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();

        doctor.setVaccinationCenter(vaccinationCenter);

        doctorRepository.save(doctor);

        vaccinationCenter.getDoctorsArrayList().add(doctor);

        vaccinationCenterRepository.save(vaccinationCenter);




        return "Doctor associated with center successfully";
    }

}

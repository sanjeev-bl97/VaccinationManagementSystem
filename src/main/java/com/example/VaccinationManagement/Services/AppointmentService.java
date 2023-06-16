package com.example.VaccinationManagement.Services;
import com.example.VaccinationManagement.Dtos.AppointmentReqDto;
import com.example.VaccinationManagement.Exceptions.DoctorNotFound;
import com.example.VaccinationManagement.Exceptions.UserNotFound;
import com.example.VaccinationManagement.Models.Appointment;
import com.example.VaccinationManagement.Models.Doctor;
import com.example.VaccinationManagement.Models.User;
import com.example.VaccinationManagement.Repository.AppointmentRepository;
import com.example.VaccinationManagement.Repository.DoctorRepository;
import com.example.VaccinationManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public String bookAppointment(AppointmentReqDto appointmentReqDto) throws DoctorNotFound, UserNotFound {

        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDocId());
        Optional<User> userOptional = userRepository.findById(appointmentReqDto.getUserId());

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFound("Doctor ID is not present");
        }
        if(userOptional.isEmpty()){
            throw new UserNotFound("User ID is not present");
        }

        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();
        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(appointmentReqDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentReqDto.getAppointmentTime());

        appointmentRepository.save(appointment);

        appointment.setDoctor(doctor);
        appointment.setUser(user);

        doctor.getAppointmentsList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        //Sending Mail

        String body = "Hi " + user.getName() + "!\n"
                        + "Your appointment for vaccination is booked on "+appointment.getAppointmentDate()+"at "+appointment.getAppointmentTime() + "\n"
                        + "Your doctor is "+doctor.getName() + "\n"
                        + "Please reach "+doctor.getVaccinationCenter().getAddress();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("pwspbl@gmail.com");
        simpleMailMessage.setTo(user.getEmailId());
        simpleMailMessage.setSubject("Appointment Details");
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);

        return "Appointment Booked Successfully";


    }

}

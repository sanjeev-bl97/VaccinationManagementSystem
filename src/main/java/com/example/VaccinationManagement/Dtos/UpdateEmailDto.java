package com.example.VaccinationManagement.Dtos;

import lombok.Data;

@Data
public class UpdateEmailDto {

    private int userId;
    private String newEmailId;

}

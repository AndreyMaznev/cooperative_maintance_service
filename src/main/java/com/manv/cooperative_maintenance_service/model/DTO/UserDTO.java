package com.manv.cooperative_maintenance_service.model.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;

    @Email
    @Size(min=6, max = 100, message = "The length should be between 5 and 100 symbols.")
    @NotBlank(message = "The email should not be empty.")
    private String email;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;


    @NotEmpty(message = "Surname should not be empty!")
    @Size(min = 2, max = 30, message = "Surname name should be between 2 and 30 characters")
    private String surName;


    private boolean isActive;

    @NotBlank
    private String mobilePhone;

    @NotNull
    private BigDecimal accountBalance;

    @NotNull
    private BigDecimal debtBalance;

    @NotBlank
    private String address;

    //Garage or other cooperative section # or address for ex "444" or "31YZ"
    @NotBlank
    private String parcelNumber;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "The birthday should have past time.")
    private LocalDate birthDate;

}

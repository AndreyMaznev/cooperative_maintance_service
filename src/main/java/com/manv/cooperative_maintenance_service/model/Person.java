package com.manv.cooperative_maintenance_service.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
    First version for the garage co-op.
 */


@Entity
@Table (name = "person")
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "person_uuid")
    private UUID uuid;

    @Column (name = "active", columnDefinition = "true", nullable = false)
    private boolean active;

    @NotEmpty (message = "Username should not be empty.")
    @Size (min = 1, max = 50, message = "Username should be between 2 and 50 characters.")
    @Column (name = "username")
    private String username;

    @NotEmpty (message = "Password should not be empty.")
    @Column (name = "password")
    private String password;

    @NotBlank
    @Column (name = "first_name")
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @NotBlank
    @Column (name = "last_name")
    @NotEmpty(message = "Surname should not be empty!")
    @Size(min = 2, max = 30, message = "Surname name should be between 2 and 30 characters")
    private String surName;

    @Column (name = "role")
    private String role;

    @Email
    @Column (name = "email")
    @NotEmpty(message = "Email should not be empty!")
    private String email;

    @NotBlank
    @Column (name = "mobile_phone")
    private String mobilePhone;

    @NotNull
    @Column (name = "balance")
    private BigDecimal balance;

    @NotBlank
    @Column (name = "address")
    private String address;

    @Column (name = "garage_number")
    private String garageNumber;

    @NotBlank
    @Column (name = "birth_date")
    private LocalDate birthDate;

    public Person() {

    }

    public Person(String firstName, String surName, String email, String mobilePhone, String address, LocalDate birthDate) {
        this.uuid = generateUUID();
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }


    public UUID getUuid() {
        return uuid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public @NotEmpty(message = "Username should not be empty.") @Size(min = 1, max = 50, message = "Username should be between 2 and 50 characters.") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "Username should not be empty.") @Size(min = 1, max = 50, message = "Username should be between 2 and 50 characters.") String username) {
        this.username = username;
    }

    public @NotEmpty(message = "Password should not be empty.") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password should not be empty.") String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public @NotBlank String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank String getSurName() {
        return surName;
    }

    public void setSurName(@NotBlank String surName) {
        this.surName = surName;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotBlank String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(@NotBlank String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public @NotNull BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(@NotNull BigDecimal balance) {
        this.balance = balance;
    }

    public @NotBlank String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank String address) {
        this.address = address;
    }

    public String getGarageNumber() {
        return garageNumber;
    }

    public void setGarageNumber(String garageNumber) {
        this.garageNumber = garageNumber;
    }

    public @NotBlank LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotBlank LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}

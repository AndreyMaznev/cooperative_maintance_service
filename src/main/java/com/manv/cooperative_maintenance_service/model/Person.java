package com.manv.cooperative_maintenance_service.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


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

    @NotBlank
    @Column (name = "first_name")
    private String firstName;

    @NotBlank
    @Column (name = "last_name")
    private String lastName;

    @Email
    @Column (name = "email")
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

    public Person(String firstName, String lastName, String email, String mobilePhone, String address, LocalDate birthDate) {
        this.uuid = generateUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }
}

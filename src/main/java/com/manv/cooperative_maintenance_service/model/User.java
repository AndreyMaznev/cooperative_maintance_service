package com.manv.cooperative_maintenance_service.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    @Size(min=6, max = 100, message = "The length should be between 5 and 100 symbols.")
    @NotBlank (message = "The email should not be empty.")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany (mappedBy = "creator")
    private List<Advertisement> advertisementList;

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

    @Column (name = "is_active", nullable = true)
    private boolean isActive;

    @NotBlank
    @Column (name = "mobile_phone")
    private String mobilePhone;

    @NotNull
    @Column (name = "account_balance")
    private BigDecimal accountBalance;

    @NotNull
    @Column (name = "debt_balance")
    private BigDecimal debtBalance;

    @NotBlank
    @Column (name = "address")
    private String address;

    //Garage or other cooperative section # or address for ex "444" or "31YZ"
    @NotBlank
    @Column (name = "parcel_number")
    private String parcelNumber;

    @NotBlank
    @Column (name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "The birthday should have past time.")
    private LocalDate birthDate;

    //created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    @Column (name = "registration_date")
    private LocalDate registrationDate;

    @Column (name = "update_date_time")
    private LocalDateTime updateDateTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        //todo
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //todo
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //todo
        return true;
    }

    @Override
    public boolean isEnabled() {
        //todo
        return true;
    }
}

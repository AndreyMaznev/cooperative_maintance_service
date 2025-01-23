package com.manv.cooperative_maintenance_service.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class AdvertisementDTO {
    @NotBlank
    @Size(max = 50, message = "Title cannot exceed 50 characters.")
    private String title;

    @NotBlank
    @Size(max = 100, message = "Short description cannot exceed 100 characters.")
    private String shortDescription;

    @NotBlank
    @Size(max = 500, message = "Full description cannot exceed 500 characters.")
    private String fullDescription;

    private LocalDateTime creationDateTime;

    private AdvertisementCategory advertisementCategory;
    }

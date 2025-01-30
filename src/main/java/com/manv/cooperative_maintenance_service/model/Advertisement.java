package com.manv.cooperative_maintenance_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "advertisements")
public class Advertisement {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "advertisement_id")
    private Long id;

    @Column (name = "title")
    @NotBlank
    private String title;

    @Column (name = "short_description")
    @NotBlank
    @Size(max = 200, message = "Short description cannot exceed 100 characters")
    private String shortDescription;

    @Column (name = "full_description")
    @NotBlank
    @Size(max = 500, message = "Full description cannot exceed 500 characters")
    private String fullDescription;

    @Column (name = "creation_date_time")
    private LocalDateTime creationDateTime;

    @Column (name = "category")
    @Enumerated(EnumType.STRING)
    private AdvertisementCategory advertisementCategory;
}

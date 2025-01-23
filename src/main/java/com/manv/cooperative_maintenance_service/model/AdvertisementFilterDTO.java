package com.manv.cooperative_maintenance_service.model;

import com.manv.cooperative_maintenance_service.repository.AdvertisementRepository;

import java.time.LocalDateTime;

public record AdvertisementFilterDTO (
        LocalDateTime fromDate,
        LocalDateTime toDate,
        AdvertisementCategory category
) {}

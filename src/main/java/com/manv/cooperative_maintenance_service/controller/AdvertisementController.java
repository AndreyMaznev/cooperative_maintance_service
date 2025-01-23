package com.manv.cooperative_maintenance_service.controller;

import com.manv.cooperative_maintenance_service.model.Advertisement;
import com.manv.cooperative_maintenance_service.model.AdvertisementCategory;
import com.manv.cooperative_maintenance_service.model.AdvertisementDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementFilterDTO;
import com.manv.cooperative_maintenance_service.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @GetMapping
    @RequestMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity <AdvertisementDTO> getAdvertisement(@PathVariable long id) {
        return new ResponseEntity<>(advertisementService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public ResponseEntity<Page<AdvertisementDTO>> getAllIncidents(
            @ModelAttribute AdvertisementFilterDTO incidentFilterDto,
            Pageable pageable) {
        Page<AdvertisementDTO> advertisements = advertisementService.getFilteredAdvertisements(
                incidentFilterDto, pageable);
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }

}

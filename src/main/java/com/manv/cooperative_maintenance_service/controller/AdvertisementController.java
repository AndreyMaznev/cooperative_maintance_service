package com.manv.cooperative_maintenance_service.controller;

import com.manv.cooperative_maintenance_service.model.AdvertisementCategory;
import com.manv.cooperative_maintenance_service.model.DTO.AdvertisementDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementFilterDTO;
import com.manv.cooperative_maintenance_service.service.AdvertisementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advertisements")
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

    @PostMapping
    public ResponseEntity<AdvertisementDTO> createAdvertisement(@RequestBody @Valid AdvertisementDTO advertisementDTO) {
        AdvertisementDTO createdAdvertisement = advertisementService.save(advertisementDTO);
        return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementDTO> updateAdvertisement(@PathVariable long id,
                                                                      @RequestBody AdvertisementDTO advertisementDTO) {
        AdvertisementDTO updatedAdvertisement = advertisementService.update(id, advertisementDTO);
        return new ResponseEntity<>(updatedAdvertisement, HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<AdvertisementDTO> updateAdvertisementStatus(@PathVariable long id,
                                                                      @RequestBody AdvertisementCategory category) {
        AdvertisementDTO updatedAdvertisement = advertisementService.updateCategory(id, category);
        return new ResponseEntity<>(updatedAdvertisement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteAdvertisement(@PathVariable long id) {
        advertisementService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

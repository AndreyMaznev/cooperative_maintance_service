package com.manv.cooperative_maintenance_service.service;


import com.manv.cooperative_maintenance_service.model.AdvertisementCategory;
import com.manv.cooperative_maintenance_service.model.DTO.AdvertisementDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdvertisementService {
    Page<AdvertisementDTO> getFilteredAdvertisements (AdvertisementFilterDTO filterDTO, Pageable pageable);
    AdvertisementDTO findById(Long id);
    AdvertisementDTO save(AdvertisementDTO advertisementDTO);
    AdvertisementDTO update(Long id, AdvertisementDTO incidentDto);
    AdvertisementDTO updateCategory(Long incidentId, AdvertisementCategory category);
    void delete(Long id);
}

package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.model.Advertisement;
import com.manv.cooperative_maintenance_service.model.DTO.AdvertisementDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementFilterDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementMapper;
import com.manv.cooperative_maintenance_service.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;
    private final AdvertisementSpecificationBuilder advertisementSpecificationBuilder;

    @Override
    public Page<AdvertisementDTO> getFilteredAdvertisements (AdvertisementFilterDTO filterDTO, Pageable pageable) {
        Specification<Advertisement> specification = advertisementSpecificationBuilder.build(filterDTO);
        Page <Advertisement> advertisements = advertisementRepository.findAll(specification, pageable);
        return advertisements.map(advertisementMapper::toDto);
    }

    @Override
    public AdvertisementDTO findById(Long id) {
        return null;
    }

    @Override
    public AdvertisementDTO save(Long creatorId, AdvertisementDTO advertisementDTO) {
        //todo
        return null;
    }

    @Override
    public AdvertisementDTO update(Long id, AdvertisementDTO incidentDto) {
        //todo
        return null;
    }

    @Override
    public AdvertisementDTO updateCategory(Long incidentId, AdvertisementDTO category) {
        //todo
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

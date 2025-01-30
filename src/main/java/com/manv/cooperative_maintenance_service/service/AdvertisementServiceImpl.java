package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.exception.advertisement.AdvertisementNotFoundException;
import com.manv.cooperative_maintenance_service.model.Advertisement;
import com.manv.cooperative_maintenance_service.model.AdvertisementCategory;
import com.manv.cooperative_maintenance_service.model.DTO.AdvertisementDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementFilterDTO;
import com.manv.cooperative_maintenance_service.model.AdvertisementMapper;
import com.manv.cooperative_maintenance_service.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Advertisement advertisement = advertisementRepository.findById(id).orElseThrow(() -> new AdvertisementNotFoundException("Advertisement not found"));
        return advertisementMapper.toDto(advertisement);
    }

    @Override
    public AdvertisementDTO save(AdvertisementDTO advertisementDTO) {
        Advertisement result = advertisementRepository.save(advertisementMapper.toEntity(advertisementDTO));
        return advertisementMapper.toDto (result);
    }

    @Override
    public AdvertisementDTO update(Long id, AdvertisementDTO advertisementDTO) {
        Advertisement result = advertisementRepository.save(advertisementMapper.toEntity(advertisementDTO));
        return advertisementMapper.toDto(result);
    }

    @Override
    public AdvertisementDTO updateCategory(Long id, AdvertisementCategory category) {
        Optional<Advertisement> result = advertisementRepository.findById(id);
        if (result.isPresent()) {
            Advertisement advertisement = result.get();
            advertisement.setAdvertisementCategory(category);
            advertisementRepository.save(advertisement);
            return advertisementMapper.toDto(advertisement);
        } else {
            throw new AdvertisementNotFoundException("Advertisement not found");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Advertisement> result = advertisementRepository.findById(id);
        if (result.isPresent()) {
            Advertisement advertisement = result.get();
            advertisementRepository.delete(advertisement);
        } else {
            throw new AdvertisementNotFoundException("Advertisement not found");
        }
    }
}

package com.manv.cooperative_maintenance_service.model;

import com.manv.cooperative_maintenance_service.model.DTO.AdvertisementDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AdvertisementMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AdvertisementMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AdvertisementDTO toDto (Advertisement advertisement) {
        return Objects.isNull(advertisement) ? null : modelMapper.map(advertisement, AdvertisementDTO.class);

    }

    public Advertisement toEntity (AdvertisementDTO advertisementDto) {
        return Objects.isNull(advertisementDto) ? null : modelMapper.map(advertisementDto, Advertisement.class);
    }
}

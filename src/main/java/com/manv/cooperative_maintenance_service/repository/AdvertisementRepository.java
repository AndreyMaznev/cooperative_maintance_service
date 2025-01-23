package com.manv.cooperative_maintenance_service.repository;

import com.manv.cooperative_maintenance_service.model.Advertisement;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdvertisementRepository extends JpaRepository <Advertisement, Long>, JpaSpecificationExecutor<Advertisement> {
    List<Advertisement> findAll(Specification<Advertisement> spec);
}


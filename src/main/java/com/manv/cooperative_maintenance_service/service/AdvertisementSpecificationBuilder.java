package com.manv.cooperative_maintenance_service.service;


import com.manv.cooperative_maintenance_service.model.Advertisement;
import com.manv.cooperative_maintenance_service.model.AdvertisementCategory;
import com.manv.cooperative_maintenance_service.model.AdvertisementFilterDTO;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class AdvertisementSpecificationBuilder {
    public Specification<Advertisement> build(AdvertisementFilterDTO filterDto) {
        return (root, query, cb) -> {
            List<Predicate> criteriaPredicates = new ArrayList<>();

            addPredicateIfNotNull(criteriaPredicates, cb, root.get("advertisementCategory"), filterDto.category());

            if (filterDto.fromDate() != null && filterDto.toDate() != null) {
                criteriaPredicates.add(cb.between(root.get("creationDateTime"), filterDto.fromDate(), filterDto.toDate()));
            }

            return cb.and(criteriaPredicates.toArray(new Predicate[0]));
        };
    }

    private <T> void addPredicateIfNotNull(List<Predicate> predicates,
                                           CriteriaBuilder cb, Path<T> field, T value) {
        if (value != null) {
            predicates.add(cb.equal(field, value));
        }
    }
}

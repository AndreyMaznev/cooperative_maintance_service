package com.manv.cooperative_maintenance_service.repository;

import com.manv.cooperative_maintenance_service.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository <Person, UUID> {

}

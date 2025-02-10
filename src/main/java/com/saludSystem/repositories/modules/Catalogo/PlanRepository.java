package com.saludSystem.repositories.modules.Catalogo;

import com.saludSystem.entities.catalogo.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {
    List<Plan> findByHospital_HospitalId(UUID hospitalId);
}
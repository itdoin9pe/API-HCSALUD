package com.saludSystem.infrastructure.repositories.modules.Catalogo;

import com.saludSystem.domain.entities.catalogo.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {
    //List<Plan> findByHospital_HospitalId(UUID hospitalId);
}
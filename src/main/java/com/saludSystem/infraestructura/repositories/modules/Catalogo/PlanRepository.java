package com.saludSystem.infraestructura.repositories.modules.Catalogo;

import com.saludSystem.dominio.entities.Catalogo.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {

    Page<Plan> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
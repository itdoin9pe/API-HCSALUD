package com.saludSystem.Catalogo.Plan.infraestructura.repositories;

import com.saludSystem.Catalogo.Plan.dominio.PlanModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<PlanModel, UUID> {

    Page<PlanModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
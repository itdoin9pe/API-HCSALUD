package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento;

import com.saludSystem.domain.model.Paciente.Tratamiento.CostoTratamientoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostoTratamientoRepository extends JpaRepository<CostoTratamientoEntity, UUID> {

    Page<CostoTratamientoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
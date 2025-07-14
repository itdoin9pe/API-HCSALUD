package com.saludsystem.submodules.adapter.jparepository.paciente.historialclinico.evolucion;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.evolucion.CambioCondicionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CambioCondicionJpaRepository extends JpaRepository<CambioCondicionEntity, Long> {
    Page<CambioCondicionEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
package com.saludSystem.Mantenimiento.Diagnostico.infraestructura.repository;

import com.saludSystem.Mantenimiento.Diagnostico.dominio.DiagnosticoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiagnosticoRepository extends JpaRepository<DiagnosticoModel, UUID> {

    Page<DiagnosticoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
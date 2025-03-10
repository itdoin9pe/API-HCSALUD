package com.saludSystem.Configuracion.Sede.infraestructura.repositories;

import com.saludSystem.Configuracion.Sede.dominio.SedeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<SedeModel, UUID> {

    List<SedeModel> findByHospital_HospitalId(UUID hospitalId);

    Page<SedeModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
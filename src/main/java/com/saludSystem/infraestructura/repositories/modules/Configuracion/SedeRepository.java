package com.saludSystem.infraestructura.repositories.modules.Configuracion;

import com.saludSystem.dominio.entities.Configuracion.Sede;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<Sede, UUID> {

    List<Sede> findByHospital_HospitalId(UUID hospitalId);

    Page<Sede> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
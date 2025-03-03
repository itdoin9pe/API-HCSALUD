package com.saludSystem.infrastructure.repositories.modules.Configuracion;

import com.saludSystem.domain.entities.Configuracion.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<Sede, UUID> {

    List<Sede> findByHospital_HospitalId(UUID hospitalId);

}
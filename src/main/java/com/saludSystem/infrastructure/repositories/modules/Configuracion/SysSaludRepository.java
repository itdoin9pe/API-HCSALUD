package com.saludSystem.infrastructure.repositories.modules.Configuracion;

import com.saludSystem.domain.entities.Configuracion.SysSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SysSaludRepository extends JpaRepository<SysSalud, UUID> {

    List<SysSalud> findByHospitalId(UUID hospitalId);

}
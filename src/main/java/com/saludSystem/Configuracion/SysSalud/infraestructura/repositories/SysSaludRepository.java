package com.saludSystem.Configuracion.SysSalud.infraestructura.repositories;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SysSaludRepository extends JpaRepository<SysSaludModel, UUID> {

    Page<SysSaludModel> findByHospitalId(UUID hospitalId, Pageable pageable);

}
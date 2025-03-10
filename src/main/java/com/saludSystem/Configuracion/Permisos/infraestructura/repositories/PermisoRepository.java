package com.saludSystem.Configuracion.Permisos.infraestructura.repositories;

import com.saludSystem.Configuracion.Permisos.dominio.PermisoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PermisoRepository extends JpaRepository<PermisoModel, UUID> {

    List<PermisoModel> findByHospitalHospitalId(UUID hospitalId);

    Page<PermisoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
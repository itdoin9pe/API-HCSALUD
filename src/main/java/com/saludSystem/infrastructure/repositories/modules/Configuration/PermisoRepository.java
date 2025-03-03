package com.saludSystem.infrastructure.repositories.modules.Configuration;

import com.saludSystem.domain.entities.configuracion.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, UUID> {

    List<Permiso> findByHospitalHospitalId(UUID hospitalId);

}
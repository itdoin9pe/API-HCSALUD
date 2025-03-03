package com.saludSystem.infraestructura.repositories.modules.Configuracion;

import com.saludSystem.dominio.entities.Configuracion.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, UUID> {

    List<Permiso> findByHospitalHospitalId(UUID hospitalId);

}
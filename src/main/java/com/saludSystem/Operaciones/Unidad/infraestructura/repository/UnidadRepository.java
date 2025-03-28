package com.saludSystem.Operaciones.Unidad.infraestructura.repository;

import com.saludSystem.Operaciones.Unidad.dominio.UnidadModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnidadRepository extends JpaRepository<UnidadModel, UUID> {

    Page<UnidadModel> findByHospital_HospitalId(UUID hospiralId, Pageable pageable);

}

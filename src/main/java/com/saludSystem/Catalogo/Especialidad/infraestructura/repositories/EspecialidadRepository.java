package com.saludSystem.Catalogo.Especialidad.infraestructura.repositories;

import com.saludSystem.Catalogo.Especialidad.dominio.EspecialidadModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EspecialidadRepository extends JpaRepository<EspecialidadModel, UUID> {

    List<EspecialidadModel> findByHospital_HospitalId(UUID hospitalId);

    Page<EspecialidadModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludSystem.Operaciones.Presentacion.infraestructura.repository;

import com.saludSystem.Operaciones.Presentacion.dominio.PresentacionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PresentacionReposirory extends JpaRepository<PresentacionModel, UUID> {

    Page<PresentacionModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

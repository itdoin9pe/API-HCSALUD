package com.saludSystem.Catalogo.Apoderado.infraestructura.repository;

import com.saludSystem.Catalogo.Apoderado.dominio.ApoderadoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApoderadoRepository extends JpaRepository<ApoderadoModel, UUID> {

    Page<ApoderadoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
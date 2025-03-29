package com.saludSystem.Operaciones.Marca.infraestructura.repository;

import com.saludSystem.Operaciones.Marca.dominio.MarcaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaModel, UUID> {

    Page<MarcaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
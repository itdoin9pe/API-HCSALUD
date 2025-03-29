package com.saludSystem.Operaciones.CategoriaMateriales.infraestructura.repository;

import com.saludSystem.Operaciones.CategoriaMateriales.dominio.CategoriaMatModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaMatRepository extends JpaRepository<CategoriaMatModel, UUID> {

    Page<CategoriaMatModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
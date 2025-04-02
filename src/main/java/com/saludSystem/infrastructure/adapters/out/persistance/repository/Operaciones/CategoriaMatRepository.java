package com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones;

import com.saludSystem.domain.model.Operaciones.CategoriaMatEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaMatRepository extends JpaRepository<CategoriaMatEntity, UUID> {

    Page<CategoriaMatEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
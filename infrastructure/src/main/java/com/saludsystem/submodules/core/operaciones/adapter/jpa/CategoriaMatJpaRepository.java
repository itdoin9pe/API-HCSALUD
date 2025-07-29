package com.saludsystem.submodules.core.operaciones.adapter.jpa;

import com.saludsystem.submodules.core.operaciones.adapter.entity.CategoriaMatEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaMatJpaRepository extends JpaRepository<CategoriaMatEntity, UUID> {
    Page<CategoriaMatEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
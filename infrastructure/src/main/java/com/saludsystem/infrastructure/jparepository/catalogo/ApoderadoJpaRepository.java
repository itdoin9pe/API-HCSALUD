package com.saludsystem.infrastructure.jparepository.catalogo;

import com.saludsystem.infrastructure.entity.catalogo.ApoderadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApoderadoJpaRepository extends JpaRepository<ApoderadoEntity, UUID> {
    Page<ApoderadoEntity> findAllHospitalId(UUID hospitalId, Pageable pageable);
    long countByHospitalId(UUID hospitalId);
}
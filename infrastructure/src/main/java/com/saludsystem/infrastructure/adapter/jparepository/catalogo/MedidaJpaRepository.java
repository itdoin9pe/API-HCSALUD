package com.saludsystem.infrastructure.adapter.jparepository.catalogo;

import com.saludsystem.infrastructure.adapter.entity.catalogo.MedidaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedidaJpaRepository extends JpaRepository<MedidaEntity, UUID> {
    Page<MedidaEntity> findAllHospitalId(UUID hospitalId, Pageable pageable);
    long countByHospitalId(UUID hospitalId);
}
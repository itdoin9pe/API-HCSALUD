package com.saludsystem.submodules.adapter.jparepository.catalogo;

import com.saludsystem.submodules.adapter.entity.catalogo.MedidaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedidaJpaRepository extends JpaRepository<MedidaEntity, UUID> {
    Page<MedidaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
    long countByHospital_HospitalId(UUID hospitalId);
}
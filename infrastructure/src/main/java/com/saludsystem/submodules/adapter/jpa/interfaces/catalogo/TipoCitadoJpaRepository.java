package com.saludsystem.submodules.adapter.jpa.interfaces.catalogo;

import com.saludsystem.submodules.adapter.entity.catalogo.TipoCitadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoCitadoJpaRepository extends JpaRepository<TipoCitadoEntity, UUID> {
    Page<TipoCitadoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
    long countByHospital_HospitalId(UUID hospitalId);
}

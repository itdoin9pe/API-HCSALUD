package com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones;

import com.saludSystem.domain.model.Operaciones.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, UUID> {

    Page<ProductoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
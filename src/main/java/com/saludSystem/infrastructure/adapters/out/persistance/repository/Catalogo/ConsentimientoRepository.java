package com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo;

import com.saludSystem.domain.model.Catalogo.ConsentimientoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsentimientoRepository extends JpaRepository<ConsentimientoEntity, UUID> {

    Page<ConsentimientoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
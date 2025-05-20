package com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo;

import com.saludSystem.domain.model.Catalogo.MedicamentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, UUID> {

    Page<MedicamentoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
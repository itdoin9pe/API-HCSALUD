package com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal;

import com.saludSystem.domain.model.Principal.AseguradoraEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AseguradoraRepository extends JpaRepository<AseguradoraEntity, UUID> {

    Page<AseguradoraEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
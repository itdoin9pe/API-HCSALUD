package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente;

import com.saludsystem.domain.model.paciente.EstudioMedicoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioMedicoRepository extends JpaRepository<EstudioMedicoEntity, Long> {

    Page<EstudioMedicoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
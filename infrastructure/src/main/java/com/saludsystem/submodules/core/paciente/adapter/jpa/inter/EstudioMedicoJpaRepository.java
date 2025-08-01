package com.saludsystem.submodules.core.paciente.adapter.jpa.inter;

import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioMedicoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioMedicoJpaRepository extends JpaRepository<EstudioMedicoEntity, Long> {

    Page<EstudioMedicoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
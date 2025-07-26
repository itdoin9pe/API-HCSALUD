package com.saludsystem.submodules.core.principal.adapter.jpa;

import com.saludsystem.submodules.core.principal.adapter.entity.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteJpaRepository extends JpaRepository<TipoPacienteEntity, Long> {
    //Page<TipoPacienteEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
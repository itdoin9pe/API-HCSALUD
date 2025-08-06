package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces;

import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioResultadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioResultadoJpaRepository extends JpaRepository<EstudioResultadoEntity, Long> {

    Page<EstudioResultadoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

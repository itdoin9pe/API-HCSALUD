package com.saludsystem.submodules.adapter.jpa.interfaces.paciente;

import com.saludsystem.submodules.adapter.entity.paciente.EstudioResultadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioResultadoJpaRepository extends JpaRepository<EstudioResultadoEntity, Long> {

    Page<EstudioResultadoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

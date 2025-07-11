package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.domain.model.EstudioResultadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioResultadoRepository extends JpaRepository<EstudioResultadoEntity, Long> {

    Page<EstudioResultadoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta;

import com.saludSystem.domain.model.Paciente.EstadoCuenta.EstadoCuentaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuentaEntity, UUID> {

    Page<EstadoCuentaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta;

import com.saludSystem.domain.model.Paciente.EstadoCuenta.PagoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, UUID> {

    Page<PagoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
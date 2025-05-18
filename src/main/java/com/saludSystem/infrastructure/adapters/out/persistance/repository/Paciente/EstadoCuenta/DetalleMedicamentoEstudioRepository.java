package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta;

import com.saludSystem.domain.model.Paciente.EstadoCuenta.DetalleMedicamentosEstudiosEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetalleMedicamentoEstudioRepository extends JpaRepository<DetalleMedicamentosEstudiosEntity, UUID> {

    Page<DetalleMedicamentosEstudiosEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
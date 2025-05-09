package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento;

import com.saludSystem.domain.model.Paciente.Tratamiento.ProcedimientoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProcedimientoRepository extends JpaRepository<ProcedimientoEntity, UUID> {

    Page<ProcedimientoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente;

import com.saludSystem.domain.model.Paciente.AnalisisOclusal1Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnalisisOclusal1Repository extends JpaRepository<AnalisisOclusal1Entity, UUID> {

    Page<AnalisisOclusal1Entity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
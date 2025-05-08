package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico;

import com.saludSystem.domain.model.Paciente.HistorialClinico.AntecedentesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AntecedenteRespository extends JpaRepository<AntecedentesEntity, UUID> {

    Page<AntecedentesEntity> findByHospital_HospitalId(UUID hopitalId, Pageable pageable);

}
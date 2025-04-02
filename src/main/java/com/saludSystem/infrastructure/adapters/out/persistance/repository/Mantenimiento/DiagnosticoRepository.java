package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.DiagnosticoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiagnosticoRepository extends JpaRepository<DiagnosticoEntity, UUID> {

    @Query("SELECT d FROM DiagnosticoEntity d WHERE d.enfermedadId LIKE :prefix% AND d.hospital.hospitalId = :hospitalId")
    List<DiagnosticoEntity> findByRolePrefixAndHospital(@Param("prefix") String prefix, @Param("hospitalId") UUID hospitalId);

    Page<DiagnosticoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
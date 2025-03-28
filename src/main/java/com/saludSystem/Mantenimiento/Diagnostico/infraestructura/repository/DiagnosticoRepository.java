package com.saludSystem.Mantenimiento.Diagnostico.infraestructura.repository;

import com.saludSystem.Mantenimiento.Diagnostico.dominio.DiagnosticoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiagnosticoRepository extends JpaRepository<DiagnosticoModel, UUID> {

    @Query("SELECT d FROM DiagnosticoModel d WHERE d.enfermedadId LIKE :prefix% AND d.hospital.hospitalId = :hospitalId")
    List<DiagnosticoModel> findByRolePrefixAndHospital(@Param("prefix") String prefix, @Param("hospitalId") UUID hospitalId);

    Page<DiagnosticoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
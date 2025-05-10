package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.EnfermedadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnfermedadRepository extends JpaRepository<EnfermedadEntity, String> {

    // Filtrado por rol
    @Query("SELECT d FROM EnfermedadEntity d WHERE d.enfermedadId LIKE :prefix% AND d.hospital.hospitalId = :hospitalId")
    List<EnfermedadEntity> findByRolePrefixAndHospital(@Param("prefix") String prefix, @Param("hospitalId") UUID hospitalId);

    Page<EnfermedadEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
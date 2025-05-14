package com.saludSystem.infrastructure.adapters.out.persistance;

import com.saludSystem.domain.model.Medico.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {

    Page<DoctorEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
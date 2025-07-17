package com.saludsystem.submodules.core.medico.adapter.jpa;

import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, UUID> {

    Page<DoctorEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
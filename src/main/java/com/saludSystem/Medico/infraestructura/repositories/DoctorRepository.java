package com.saludSystem.Medico.infraestructura.repositories;

import com.saludSystem.Medico.dominio.DoctorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {

    Page<DoctorModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
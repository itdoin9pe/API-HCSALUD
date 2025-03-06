package com.saludSystem.infraestructura.repositories.modules.Doctor;

import com.saludSystem.dominio.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    Page<Doctor> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
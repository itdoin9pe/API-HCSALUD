package com.saludSystem.infraestructura.repositories.modules.Doctor;

import com.saludSystem.dominio.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    List<Doctor> findByHospital_HospitalId(UUID hospitalId);

}
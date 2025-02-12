package com.saludSystem.repositories.modules.Generals;

import com.saludSystem.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
    List<Pais> findByHospital_HospitalId(UUID hospitalId);
}

package com.saludSystem.Generals.adapter.Pais.infraestructura.repositories;

import com.saludSystem.Generals.adapter.Pais.domain.PaisModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<PaisModel, Integer> {

    Page<PaisModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
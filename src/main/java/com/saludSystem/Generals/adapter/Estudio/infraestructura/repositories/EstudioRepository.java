package com.saludSystem.Generals.adapter.Estudio.infraestructura.repositories;

import com.saludSystem.Generals.adapter.Estudio.domain.EstudioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioRepository extends JpaRepository<EstudioModel, UUID> {

    Page<EstudioModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
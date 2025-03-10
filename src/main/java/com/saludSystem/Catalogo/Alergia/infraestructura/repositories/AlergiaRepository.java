package com.saludSystem.Catalogo.Alergia.infraestructura.repositories;

import com.saludSystem.Catalogo.Alergia.dominio.AlergiaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlergiaRepository extends JpaRepository<AlergiaModel, UUID> {

    Page<AlergiaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
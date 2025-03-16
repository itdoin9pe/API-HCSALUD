package com.saludSystem.Generals.adapter.Aseguradora.infraestructura.repositories;

import com.saludSystem.Generals.adapter.Aseguradora.dominio.AseguradoraModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AseguradoraRepository extends JpaRepository<AseguradoraModel, UUID> {

    Page<AseguradoraModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
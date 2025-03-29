package com.saludSystem.Mantenimiento.Cajas.infraestructura.repository;

import com.saludSystem.Mantenimiento.Cajas.dominio.CajaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CajaRepository extends JpaRepository<CajaModel, UUID> {

    Page<CajaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
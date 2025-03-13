package com.saludSystem.Catalogo.Consentimiento.infraestructura.repository;

import com.saludSystem.Catalogo.Consentimiento.dominio.ConsentimientoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsentimientoRepository extends JpaRepository<ConsentimientoModel, UUID> {

    Page<ConsentimientoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
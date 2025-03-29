package com.saludSystem.Mantenimiento.TipoPago.infraestructura.repository;

import com.saludSystem.Mantenimiento.TipoPago.dominio.TipoPagoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoPagoRepository extends JpaRepository<TipoPagoModel, UUID> {

    Page<TipoPagoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
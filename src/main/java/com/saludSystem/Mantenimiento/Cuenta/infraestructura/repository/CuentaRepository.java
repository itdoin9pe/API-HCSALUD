package com.saludSystem.Mantenimiento.Cuenta.infraestructura.repository;

import com.saludSystem.Mantenimiento.Cuenta.dominio.CuentaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaModel, UUID> {

    Page<CuentaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

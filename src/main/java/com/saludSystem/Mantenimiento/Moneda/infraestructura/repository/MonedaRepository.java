package com.saludSystem.Mantenimiento.Moneda.infraestructura.repository;

import com.saludSystem.Mantenimiento.Moneda.dominio.MonedaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonedaRepository extends JpaRepository<MonedaModel, UUID> {

    Page<MonedaModel> findByHospital_HospitalId(UUID monedaId, Pageable pageable);

}

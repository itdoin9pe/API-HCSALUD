package com.saludSystem.Mantenimiento.TipoGasto.infraestructura.repository;

import com.saludSystem.Mantenimiento.TipoGasto.dominio.TipoGastoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoGastoRepository extends JpaRepository<TipoGastoModel, UUID> {

    Page<TipoGastoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

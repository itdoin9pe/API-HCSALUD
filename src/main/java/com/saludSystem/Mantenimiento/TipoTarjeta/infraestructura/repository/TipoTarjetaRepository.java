package com.saludSystem.Mantenimiento.TipoTarjeta.infraestructura.repository;

import com.saludSystem.Mantenimiento.TipoTarjeta.dominio.TipoTarjetaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoTarjetaRepository extends JpaRepository<TipoTarjetaModel, UUID> {

    Page<TipoTarjetaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
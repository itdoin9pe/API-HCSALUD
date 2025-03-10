package com.saludSystem.Catalogo.TipoCitado.infraestructura.repositories;

import com.saludSystem.Catalogo.TipoCitado.dominio.TipoCitadoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoCitadoRepository extends JpaRepository<TipoCitadoModel, UUID> {

    Page<TipoCitadoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

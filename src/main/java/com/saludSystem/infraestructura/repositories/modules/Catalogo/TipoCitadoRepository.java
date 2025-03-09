package com.saludSystem.infraestructura.repositories.modules.Catalogo;

import com.saludSystem.dominio.entities.Catalogo.TipoCitado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoCitadoRepository extends JpaRepository<TipoCitado, UUID> {

    Page<TipoCitado> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

package com.saludSystem.Configuracion.TipoDocumento.infraestructura.repositories;

import com.saludSystem.Configuracion.TipoDocumento.dominio.TipoDocumentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoModel, UUID> {

 Page<TipoDocumentoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
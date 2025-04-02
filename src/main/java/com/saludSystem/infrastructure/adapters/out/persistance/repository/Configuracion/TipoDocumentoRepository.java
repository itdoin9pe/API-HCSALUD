package com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion;

import com.saludSystem.domain.model.Configuracion.TipoDocumentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, UUID> {

 Page<TipoDocumentoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
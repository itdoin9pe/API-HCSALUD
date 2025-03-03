package com.saludSystem.infrastructure.repositories.modules.Configuration;

import com.saludSystem.domain.entities.configuracion.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, UUID> {

 List<TipoDocumento> findByHospital_HospitalId(UUID hospitalId);

}
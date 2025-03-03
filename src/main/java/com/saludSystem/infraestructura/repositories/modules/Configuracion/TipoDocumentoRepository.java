package com.saludSystem.infraestructura.repositories.modules.Configuracion;

import com.saludSystem.dominio.entities.Configuracion.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, UUID> {

 List<TipoDocumento> findByHospital_HospitalId(UUID hospitalId);

}
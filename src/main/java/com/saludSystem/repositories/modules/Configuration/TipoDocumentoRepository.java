package com.saludSystem.repositories.modules.Configuration;

import com.saludSystem.entities.configuracion.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}

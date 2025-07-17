package com.saludsystem.submodules.sections.configuracion.adapter.jpa;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoDocumentoJpaRepository extends JpaRepository<TipoDocumentoEntity, UUID> {

}
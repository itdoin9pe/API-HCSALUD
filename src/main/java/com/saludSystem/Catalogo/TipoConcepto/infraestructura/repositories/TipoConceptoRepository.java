package com.saludSystem.Catalogo.TipoConcepto.infraestructura.repositories;

import com.saludSystem.Catalogo.TipoConcepto.dominio.TipoConceptoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoConceptoRepository extends JpaRepository<TipoConceptoModel, UUID> {

    Page<TipoConceptoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
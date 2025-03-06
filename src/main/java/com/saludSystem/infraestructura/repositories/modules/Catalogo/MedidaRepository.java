package com.saludSystem.infraestructura.repositories.modules.Catalogo;

import com.saludSystem.dominio.entities.Catalogo.Medida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, UUID> {

    List<Medida> findByHospital_HospitalId(UUID hospitalId);

    Page<Medida> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

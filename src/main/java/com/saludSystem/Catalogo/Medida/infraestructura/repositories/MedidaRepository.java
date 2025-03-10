package com.saludSystem.Catalogo.Medida.infraestructura.repositories;

import com.saludSystem.Catalogo.Medida.dominio.MedidaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface MedidaRepository extends JpaRepository<MedidaModel, UUID> {

    List<MedidaModel> findByHospital_HospitalId(UUID hospitalId);

    Page<MedidaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
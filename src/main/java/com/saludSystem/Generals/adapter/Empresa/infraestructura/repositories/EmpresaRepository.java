package com.saludSystem.Generals.adapter.Empresa.infraestructura.repositories;

import com.saludSystem.Generals.adapter.Empresa.dominio.EmpresaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, UUID> {

    Page<EmpresaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
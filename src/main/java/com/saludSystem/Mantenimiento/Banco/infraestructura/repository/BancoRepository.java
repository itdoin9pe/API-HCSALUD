package com.saludSystem.Mantenimiento.Banco.infraestructura.repository;

import com.saludSystem.Mantenimiento.Banco.dominio.BancoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BancoRepository extends JpaRepository<BancoModel, UUID> {

    Page<BancoModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

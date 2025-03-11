package com.saludSystem.Catalogo.Clientes.infraestructura.repositories;

import com.saludSystem.Catalogo.Clientes.dominio.ClienteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

    Page<ClienteModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludSystem.infrastructure.repositories.Generals;

import com.saludSystem.domain.entities.Generals.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, UUID> {

    List<Sucursal> findByHospital_HospitalId(UUID hospitalId);

}
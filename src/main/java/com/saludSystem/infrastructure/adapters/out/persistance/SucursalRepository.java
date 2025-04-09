package com.saludSystem.infrastructure.adapters.out.persistance;

import com.saludSystem.domain.model.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, UUID> {

    List<SucursalEntity> findByHospital_HospitalId(UUID hospitalId);

    Optional<SucursalEntity> findFirstByOrderBySucursalIdAsc();

}
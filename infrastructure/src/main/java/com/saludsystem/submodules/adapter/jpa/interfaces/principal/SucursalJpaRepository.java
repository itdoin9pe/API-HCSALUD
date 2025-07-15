package com.saludsystem.submodules.adapter.jpa.interfaces.principal;

import com.saludsystem.submodules.adapter.entity.principal.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SucursalJpaRepository extends JpaRepository<SucursalEntity, UUID> {

    List<SucursalEntity> findByHospital_HospitalId(UUID hospitalId);

    Optional<SucursalEntity> findFirstByOrderBySucursalIdAsc();

}
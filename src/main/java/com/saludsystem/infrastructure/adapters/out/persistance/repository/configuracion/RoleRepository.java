package com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion;

import com.saludsystem.domain.model.configuracion.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

    Optional<RoleEntity> findByRoleId(UUID roleId);

    Page<RoleEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
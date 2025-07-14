package com.saludsystem.submodules.adapter.jparepository.configuracion;

import com.saludsystem.submodules.adapter.entity.configuracion.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, UUID> {

    Optional<RoleEntity> findByRoleId(UUID roleId);

    Page<RoleEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
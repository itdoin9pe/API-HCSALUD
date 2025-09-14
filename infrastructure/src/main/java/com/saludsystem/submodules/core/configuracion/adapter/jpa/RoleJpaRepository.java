package com.saludsystem.submodules.core.configuracion.adapter.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, UUID>
{
	Optional<RoleEntity> findByRoleId(UUID roleId);

	Page<RoleEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
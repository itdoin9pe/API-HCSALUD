package com.saludsystem.submodules.core.principal.adapter.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.principal.adapter.entity.SucursalEntity;

@Repository
public interface SucursalJpaRepository extends JpaRepository<SucursalEntity, UUID>
{
	Page<SucursalEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

	Optional<SucursalEntity> findFirstByOrderBySucursalIdAsc();
}

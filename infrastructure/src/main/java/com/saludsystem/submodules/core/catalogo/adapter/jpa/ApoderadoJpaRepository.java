package com.saludsystem.submodules.core.catalogo.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;

@Repository
public interface ApoderadoJpaRepository extends JpaRepository<ApoderadoEntity, UUID>
{
	Page<ApoderadoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

	long countByHospital_HospitalId(UUID hospitalId);
}
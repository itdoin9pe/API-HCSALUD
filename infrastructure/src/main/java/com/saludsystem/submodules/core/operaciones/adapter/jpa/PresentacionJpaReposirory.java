package com.saludsystem.submodules.core.operaciones.adapter.jpa;

import com.saludsystem.submodules.core.operaciones.adapter.entity.PresentacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PresentacionJpaReposirory extends JpaRepository<PresentacionEntity, UUID> {

    Page<PresentacionEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
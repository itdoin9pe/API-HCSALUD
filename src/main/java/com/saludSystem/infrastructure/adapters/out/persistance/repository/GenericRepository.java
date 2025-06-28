package com.saludSystem.infrastructure.adapters.out.persistance.repository;

import com.saludSystem.domain.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {

    Page<T> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
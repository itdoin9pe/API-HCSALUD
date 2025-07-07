package com.saludsystem.shared.infrastructure.adapters.out.persistance;

import com.saludsystem.shared.domain.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<E extends BaseEntity> extends JpaRepository<E, UUID> {

    Page<E> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
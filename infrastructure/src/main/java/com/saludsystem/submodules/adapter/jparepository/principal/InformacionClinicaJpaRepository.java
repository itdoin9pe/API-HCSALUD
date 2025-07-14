package com.saludsystem.submodules.adapter.jparepository.principal;

import com.saludsystem.submodules.adapter.entity.principal.InformacionClinicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InformacionClinicaJpaRepository extends JpaRepository<InformacionClinicaEntity, UUID> {

}
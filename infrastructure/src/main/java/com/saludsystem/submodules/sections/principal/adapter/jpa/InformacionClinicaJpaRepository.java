package com.saludsystem.submodules.sections.principal.adapter.jpa;

import com.saludsystem.submodules.sections.principal.adapter.entity.InformacionClinicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InformacionClinicaJpaRepository extends JpaRepository<InformacionClinicaEntity, UUID> {

}
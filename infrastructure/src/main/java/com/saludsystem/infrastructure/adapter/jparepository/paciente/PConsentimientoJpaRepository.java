package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.infrastructure.adapter.entity.paciente.PConsentimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PConsentimientoJpaRepository extends JpaRepository<PConsentimientoEntity, UUID> {

}
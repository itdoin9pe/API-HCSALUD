package com.saludsystem.submodules.sections.principal.adapter.jpa;

import com.saludsystem.submodules.sections.principal.adapter.entity.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteJpaRepository extends JpaRepository<TipoPacienteEntity, Long> {
    // some methods soon...
}
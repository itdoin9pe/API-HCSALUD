package com.saludsystem.infrastructure.adapters.out.persistance.repository.principal;

import com.saludsystem.domain.model.principal.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteRepository extends JpaRepository<TipoPacienteEntity, Long> {
    // some methods soon...
}
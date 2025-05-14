package com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal;

import com.saludSystem.domain.model.Principal.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteRepository extends JpaRepository<TipoPacienteEntity, Long> {
    // some methods soon...
}
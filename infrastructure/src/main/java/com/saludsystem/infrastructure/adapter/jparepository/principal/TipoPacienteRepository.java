package com.saludsystem.infrastructure.adapter.jparepository.principal;

import com.saludsystem.domain.model.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteRepository extends JpaRepository<TipoPacienteEntity, Long> {
    // some methods soon...
}
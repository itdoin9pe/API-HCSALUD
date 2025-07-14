package com.saludsystem.infrastructure.adapter.jparepository.principal;

import com.saludsystem.infrastructure.adapter.entity.principal.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteJpaRepository extends JpaRepository<TipoPacienteEntity, Long> {
    // some methods soon...
}
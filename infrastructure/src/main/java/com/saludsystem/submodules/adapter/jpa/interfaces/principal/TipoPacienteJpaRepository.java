package com.saludsystem.submodules.adapter.jpa.interfaces.principal;

import com.saludsystem.submodules.adapter.entity.principal.TipoPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteJpaRepository extends JpaRepository<TipoPacienteEntity, Long> {
    // some methods soon...
}
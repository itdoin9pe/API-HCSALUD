package com.saludSystem.Generals.adapter.TipoPaciente.infraestructura.repositories;

import com.saludSystem.Generals.adapter.TipoPaciente.domain.TipoPacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPacienteRepository extends JpaRepository<TipoPacienteModel, Long> {
    // some methods soon...
}
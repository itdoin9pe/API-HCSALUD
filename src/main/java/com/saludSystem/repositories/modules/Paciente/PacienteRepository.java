package com.saludSystem.repositories.modules.Paciente;

import com.saludSystem.entities.Paciente;
import com.saludSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findBySpecialtyAndCreatedBy(String specialty, User createdBy);

}

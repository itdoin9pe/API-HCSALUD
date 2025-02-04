package com.saludSystem.repositories.modules.Catalogo;

import com.saludSystem.entities.catalogo.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, UUID> {
}

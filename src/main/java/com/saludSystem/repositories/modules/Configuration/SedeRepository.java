package com.saludSystem.repositories.modules.Configuration;

import com.saludSystem.entities.configuracion.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SedeRepository extends JpaRepository<Sede, UUID> {
}

package com.saludSystem.repositories.modules.Generals;

import com.saludSystem.entities.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, UUID> {
}

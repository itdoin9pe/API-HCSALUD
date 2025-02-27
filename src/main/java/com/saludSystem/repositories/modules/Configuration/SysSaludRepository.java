package com.saludSystem.repositories.modules.Configuration;

import com.saludSystem.entities.configuracion.SysSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SysSaludRepository extends JpaRepository<SysSalud, UUID> {

    List<SysSalud> findByHospitalId(UUID hospitalId);

}
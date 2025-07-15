package com.saludsystem.submodules.adapter.jpa.interfaces.paciente.historialclinico.estadocuenta;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.estadocuenta.EstadoCuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoCuentaJpaRepository extends JpaRepository<EstadoCuentaEntity, UUID> {

}
package com.saludsystem.submodules.adapter.jparepository.paciente.historialclinico.estadocuenta;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.estadocuenta.DetalleMedicamentosEstudiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetalleMedicamentoEstudioJpaRepository extends JpaRepository<DetalleMedicamentosEstudiosEntity, UUID> {

}
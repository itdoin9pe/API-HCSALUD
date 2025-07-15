package com.saludsystem.submodules.adapter.jpa.interfaces.paciente;

import com.saludsystem.submodules.adapter.entity.paciente.MedicamentoRecetadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicamentoRecetadoJpaRepository extends JpaRepository<MedicamentoRecetadoEntity, UUID> {

}
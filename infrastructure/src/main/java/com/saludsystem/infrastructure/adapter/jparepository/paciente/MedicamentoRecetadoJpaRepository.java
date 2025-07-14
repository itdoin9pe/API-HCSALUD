package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.infrastructure.adapter.entity.paciente.MedicamentoRecetadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicamentoRecetadoJpaRepository extends JpaRepository<MedicamentoRecetadoEntity, UUID> {

}
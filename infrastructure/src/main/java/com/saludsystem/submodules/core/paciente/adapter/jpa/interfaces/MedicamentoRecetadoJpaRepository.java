package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces;

import com.saludsystem.submodules.core.paciente.adapter.entity.MedicamentoRecetadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicamentoRecetadoJpaRepository extends JpaRepository<MedicamentoRecetadoEntity, UUID> {

    Page<MedicamentoRecetadoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
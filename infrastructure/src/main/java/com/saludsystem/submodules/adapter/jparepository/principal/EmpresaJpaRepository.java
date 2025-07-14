package com.saludsystem.submodules.adapter.jparepository.principal;

import com.saludsystem.submodules.adapter.entity.principal.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpresaJpaRepository extends JpaRepository<EmpresaEntity, UUID> {

}
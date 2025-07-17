package com.saludsystem.submodules.sections.operaciones.adapter.jpa;

import com.saludsystem.submodules.sections.operaciones.adapter.entity.PresentacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PresentacionJpaReposirory extends JpaRepository<PresentacionEntity, UUID> {

}
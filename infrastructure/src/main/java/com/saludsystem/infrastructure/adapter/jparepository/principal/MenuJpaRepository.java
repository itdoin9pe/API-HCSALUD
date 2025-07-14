package com.saludsystem.infrastructure.adapter.jparepository.principal;

import com.saludsystem.infrastructure.adapter.entity.principal.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuJpaRepository extends JpaRepository<MenuEntity, UUID> {

    List<MenuEntity> findByHospitalHospitalId(UUID hospitalId);

}

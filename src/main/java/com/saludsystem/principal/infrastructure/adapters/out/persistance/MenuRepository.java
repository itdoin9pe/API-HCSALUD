package com.saludsystem.principal.infrastructure.adapters.out.persistance;

import com.saludsystem.shared.domain.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {

    List<MenuEntity> findByHospitalHospitalId(UUID hospitalId);

}

package com.saludSystem.Configuracion.Roles.infraestructura.repositories;

import com.saludSystem.Configuracion.Roles.dominio.RoleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, UUID> {

    List<RoleModel> findByHospital_HospitalId(UUID hospitalId);

    Optional<RoleModel> findByRoleId(UUID roleId);

    Page<RoleModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
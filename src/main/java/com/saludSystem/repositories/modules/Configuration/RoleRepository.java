package com.saludSystem.repositories.modules.Configuration;

import com.saludSystem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    List<Role> findByHospital_HospitalId(UUID hospitalId);

    Optional<Role> findByRoleId(UUID roleId);

}
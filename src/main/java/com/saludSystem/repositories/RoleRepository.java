package com.saludSystem.repositories;

import com.saludSystem.entities.Role;
import com.saludSystem.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(UserRole name);

    //Optional<Role> findById_RoleId(UUID roleId);

}
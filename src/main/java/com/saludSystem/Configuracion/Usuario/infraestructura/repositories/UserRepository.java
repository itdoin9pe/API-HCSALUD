package com.saludSystem.Configuracion.Usuario.infraestructura.repositories;

import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Page<UserModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
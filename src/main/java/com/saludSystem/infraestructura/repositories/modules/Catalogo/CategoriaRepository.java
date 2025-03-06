package com.saludSystem.infraestructura.repositories.modules.Catalogo;

import com.saludSystem.dominio.entities.Catalogo.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

    List<Categoria> findByHospital_HospitalId(UUID hospitalId);

    Page<Categoria> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
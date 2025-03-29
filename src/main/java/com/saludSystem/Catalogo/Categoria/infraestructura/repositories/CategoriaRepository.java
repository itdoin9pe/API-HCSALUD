package com.saludSystem.Catalogo.Categoria.infraestructura.repositories;

import com.saludSystem.Catalogo.Categoria.dominio.CategoriaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, UUID> {

    //List<CategoriaModel> findByHospital_HospitalId(UUID hospitalId);

    Page<CategoriaModel> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludSystem.repositories.modules.Generals;

import com.saludSystem.entities.Aseguradora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface AseguradoraRepository extends JpaRepository<Aseguradora, UUID> {

    // Búsqueda por descripción (ignorar mayúsculas/minúsculas)
    List<Aseguradora> findByDescripcionIgnoreCase(String descripcion);

    // Búsqueda por estado (activo/inactivo)
    List<Aseguradora> findByEstado(Integer estado);

    // Búsqueda por descripción parcial
    List<Aseguradora> findByDescripcionContainingIgnoreCase(String keyword);

    // Contar aseguradoras por estado
    long countByEstado(Integer estado);

    // Consultas personalizadas
    /*
    @Query("SELECT a FROM aseguradoras a WHERE a.estado = true ORDER BY a.descripcion ASC")
    List<Aseguradora> findActiveAseguradorasOrderedByDescripcion();

    @Query("SELECT a FROM aseguradoras a WHERE LOWER(a.descripcion) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Aseguradora> searchByKeyword(@Param("keyword") String keyword);
    */

    // Paginación y ordenación personalizada
    Page<Aseguradora> findByEstado(Integer estado, Pageable pageable);

    // Filtros combinados
    List<Aseguradora> findByDescripcionContainingIgnoreCaseAndEstado(String descripcion, Integer estado);
}
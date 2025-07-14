package com.saludsystem.submodules.adapter.jparepository.operaciones;

import com.saludsystem.submodules.movimiento.port.in.service.InventarioProjection;
import com.saludsystem.submodules.adapter.entity.operaciones.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, UUID> {

    Page<ProductoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

    @Query(value = """
        SELECT 
            (SELECT nombre FROM almacenes WHERE hospital_id = :hospitalId LIMIT 1) AS nombreAlmacen,
            p.nombre_producto AS nombreProducto,
            m.nombre_marca AS nombreMarca,
            c.nombre_categoria AS nombreCategoria,
            p.precio_venta_producto AS precioEntrada,
            u.nombre_unidad AS unidad,
            p.stock_producto AS stock
        FROM productos p
        JOIN marcas_materiales m ON p.marca_materiales_id = m.marca_materiales_id
        JOIN categoria c ON p.categoria_material_id = c.categoria_material_id
        JOIN unidades u ON p.unidad_id = u.unidad_id
        WHERE p.hospital_id = :hospitalId
        """,
            nativeQuery = true,
            countQuery = """
        SELECT COUNT(*)
        FROM productos p
        WHERE p.hospital_id = :hospitalId
        """)
    Page<InventarioProjection> findInventarioDataByHospitalId(@Param("hospitalId") UUID hospitalId, Pageable pageable);

}
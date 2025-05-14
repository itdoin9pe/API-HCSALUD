package com.saludSystem.domain.model.Movimientos;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Operaciones.CategoriaMatEntity;
import com.saludSystem.domain.model.Operaciones.MarcaEntity;
import com.saludSystem.domain.model.Operaciones.ProductoEntity;
import com.saludSystem.domain.model.Operaciones.UnidadEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "inventario")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class InventarioEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "inventario_id", nullable = false)
    private UUID inventarioId;

    @ManyToOne
    @JoinColumn(name = "almacen_id", nullable = true)
    private AlmacenEntity almacenEntity;

    @Column(name = "tipoDocumentoId", nullable = false)
    private int tipoInventarioId;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity productoEntity;

    @ManyToOne
    @JoinColumn(name = "marcaMateriales_id", nullable = false)
    private MarcaEntity marcaMaterialEntity;

    @ManyToOne
    @JoinColumn(name = "categoriaMaterial_id", nullable = false)
    private CategoriaMatEntity categoriaMatEntity;

    @ManyToOne
    @JoinColumn(name = "unidad_id", nullable = false)
    private UnidadEntity unidadEntity;

    @Column(name = "precioEntrada_inventario", nullable = false)
    private BigDecimal precioEntrada;

    @Column(name = "precioSalida_inventario", nullable = false)
    private BigDecimal precioSalida;

    @Column(name = "stock_inventario", nullable = false)
    private Integer stock;

    @Column(name = "fecha_inventario", nullable = false)
    private LocalDate fecha;

    @Column(name = "estado_inventario", nullable = false)
    private Integer estado;

}
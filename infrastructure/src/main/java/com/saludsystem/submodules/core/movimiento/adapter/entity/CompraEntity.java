package com.saludsystem.submodules.core.movimiento.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProveedorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "compras")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CompraEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "compra_id", nullable = false)
    private UUID compraId;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fecha;

    @Column(name = "tipoDocumento_compra", nullable = false)
    private String tipoDocumento;

    @Column(name = "numeroDocumento_compra", nullable = false)
    private String nroDocumento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "proveedor_id", nullable = false)
    private ProveedorEntity proveedorEntity;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_tipoPagos", nullable = false)
    private TipoPagoEntity tipoPagoEntity;

    @ManyToOne
    @JoinColumn(referencedColumnName = "almacen_id", nullable = false)
    private AlmacenEntity almacenEntity;

    @Column(name = "efectivo_compra", nullable = false)
    private BigDecimal efectivo_total;

    @Column(name = "guiaRemision", nullable = false)
    private String guiaRemision;

    @Column(name = "observacion_compra", nullable = false)
    private String observacion;

    @Column(name = "estado_compra", nullable = false)
    private Integer estado;

    @OneToMany(mappedBy = "compraEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraDetalleEntity> detalle;

}
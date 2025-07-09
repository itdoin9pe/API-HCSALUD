package com.saludsystem.movimientos.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.operaciones.domain.model.ProductoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "compra_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class CompraDetalleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "compraDetalle_id", nullable = false)
    private UUID compraDetalleId;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private CompraEntity compraEntity;

    @ManyToOne
    @JoinColumn(referencedColumnName = "producto_id", nullable = false)
    private ProductoEntity productoEntity;

    @Column(name = "cantidad_compras", nullable = false)
    private int cantidad;

    @Column(name = "precioUnitario", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "igv_compraDetalle", nullable = false)
    private BigDecimal igv;

    @Column(name = "precioVenta_compraDetalle", nullable = false)
    private BigDecimal precioVenta;

    @Column(name = "subtotal_compraDetalle", nullable = false)
    private BigDecimal subtotal;

}
package com.saludSystem.infrastructure.adapters.in.controllers.Movimiento;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Movimientos.VentaEntity;
import com.saludSystem.domain.model.Operaciones.ProductoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "venta_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class VentaDetalleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ventaDetalleId", nullable = false)
    private UUID ventaDetalleId;

    @Column(name = "codigo_producto", nullable = false)
    private String codigoProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private VentaEntity ventaEntity;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity productoEntity;

}
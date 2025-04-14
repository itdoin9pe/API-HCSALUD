package com.saludSystem.domain.model.Movimientos;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Configuracion.SedeEntity;
import com.saludSystem.domain.model.Operaciones.ProveedorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "compras")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
    @JoinColumn(referencedColumnName = "almacen_id", nullable = false)
    private AlmacenEntity almacenEntity;

    @Column(name = "efectivo_compra", nullable = false)
    private BigDecimal efectivo;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldoCompra;

    @Column(name = "pago_compra", nullable = false)
    private String pago;

    @Column(name = "moneda_compra", nullable = false)
    private String moneda;

    @Column(name = "guiaRemision", nullable = false)
    private String guiaRemision;

    @Column(name = "observacion_compra", nullable = false)
    private String observaacion;

    @Column(name = "loginUsuario", nullable = false)
    private String loginUsuario;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_sede", nullable = false)
    private SedeEntity sedeEntity;

    @Column(name = "dias", nullable = false)
    private int dias;

    @Column(name = "fechaNacimiento_compra", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "total_compra", nullable = false)
    private BigDecimal total;

    @Column(name = "igv_compra", nullable = false)
    private BigDecimal igv;

    @Column(name = "subtotal_compra", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "pendiente_compra", nullable = false)
    private int pendiente;

    @Column(name = "estado_compra", nullable = false)
    private String estado;

    @OneToMany(mappedBy = "compraEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraDetalleEntity> detalle;

}
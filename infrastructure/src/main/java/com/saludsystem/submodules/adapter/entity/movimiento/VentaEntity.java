package com.saludsystem.submodules.adapter.entity.movimiento;

import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.TipoDocumentoEntity;
import com.saludsystem.submodules.adapter.entity.mantenimiento.MonedaEntity;
import com.saludsystem.submodules.adapter.entity.mantenimiento.TipoPagoEntity;
import com.saludsystem.submodules.adapter.entity.mantenimiento.TipoTarjetaEntity;
import com.saludsystem.submodules.adapter.entity.paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class VentaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "venta_id", nullable = false)
    private UUID ventaId;

    @Column(name = "serie_venta", nullable = false)
    private String serie;

    @Column(name = "secuencia_venta", nullable = false)
    private String secuencia;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDate fecha;

    @Column(name = "tipo_beneficiario", nullable = false)
    private String tipoBeneficiario;

    @Column(name = "beneficiario_documento", nullable = false)
    private String beneficiarioDocumento;

    @Column(name = "beneficiario_direccion", nullable = false)
    private String beneficiarioDireccion;

    @ManyToOne
    @JoinColumn(name = "id_tipoPagos", nullable = false)
    private TipoPagoEntity tipoPagoEntity;

    @Column(name = "observacion", nullable = false)
    private String observacion;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Column(name = "monto_recibido", precision = 10, scale = 2, nullable = false)
    private BigDecimal montoRecibido;

    @Column(name = "vuelto", precision = 10, scale = 2, nullable = false)
    private BigDecimal vuelto;

    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "tipo_documento_id", nullable = false)
    private TipoDocumentoEntity tipoDocumentoEntity;

    @ManyToOne
    @JoinColumn(name = "almacen_id", nullable = false)
    private AlmacenEntity almacenEntity;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private PacienteEntity beneficiarioId;

    @ManyToOne
    @JoinColumn(name = "tipo_tarjeta_id", nullable = false)
    private TipoTarjetaEntity tipoTarjetaEntity;

    @ManyToOne
    @JoinColumn(name = "tipo_moneda_id", nullable = false)
    private MonedaEntity tipoMonedaEntity;

    @OneToMany(mappedBy = "ventaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaDetalleEntity> detalle;

    @Column(name = "estado_ventas", nullable = false)
    private Integer estado;

}
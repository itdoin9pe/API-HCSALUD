package com.saludsystem.movimientos.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.configuracion.domain.model.TipoDocumentoEntity;
import com.saludsystem.mantenimiento.domain.model.MonedaEntity;
import com.saludsystem.mantenimiento.domain.model.TipoPagoEntity;
import com.saludsystem.mantenimiento.domain.model.TipoTarjetaEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
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
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
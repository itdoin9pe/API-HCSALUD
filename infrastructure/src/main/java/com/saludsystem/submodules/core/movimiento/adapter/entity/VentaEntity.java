package com.saludsystem.submodules.core.movimiento.adapter.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.TipoDocumentoEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.MonedaEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoTarjetaEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class VentaEntity extends BaseEntity
{
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
package com.saludsystem.submodules.movimiento.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Venta
{
	private UUID ventaId;
	private String serie;
	private String secuencia;
	private LocalDate fecha;
	private String tipoBeneficiario;
	private String beneficiarioDocumento;
	private String beneficiarioDireccion;
	private UUID tipoPagoId;
	private String observacion;
	private String metodoPago;
	private BigDecimal montoRecibido;
	private BigDecimal vuelto;
	private BigDecimal total;
	private UUID tipoDocumentoId;
	private UUID almacenId;
	private UUID beneficiarioId;
	private UUID tipoTarjetaId;
	private UUID tipoMonedaId;
	private Integer estado;
	private List<VentaDetalle> detalles;

	public Venta(
		UUID ventaId,
		String serie,
		String secuencia,
		LocalDate fecha,
		String tipoBeneficiario,
		String beneficiarioDocumento,
		String beneficiarioDireccion,
		UUID tipoPagoId,
		String observacion,
		String metodoPago,
		BigDecimal montoRecibido,
		BigDecimal vuelto,
		BigDecimal total,
		UUID tipoDocumentoId,
		UUID almacenId,
		UUID beneficiarioId,
		UUID tipoTarjetaId,
		UUID tipoMonedaId,
		Integer estado,
		List<VentaDetalle> detalles)
	{
		this.ventaId = ventaId;
		this.serie = serie;
		this.secuencia = secuencia;
		this.fecha = fecha;
		this.tipoBeneficiario = tipoBeneficiario;
		this.beneficiarioDocumento = beneficiarioDocumento;
		this.beneficiarioDireccion = beneficiarioDireccion;
		this.tipoPagoId = tipoPagoId;
		this.observacion = observacion;
		this.metodoPago = metodoPago;
		this.montoRecibido = montoRecibido;
		this.vuelto = vuelto;
		this.total = total;
		this.tipoDocumentoId = tipoDocumentoId;
		this.almacenId = almacenId;
		this.beneficiarioId = beneficiarioId;
		this.tipoTarjetaId = tipoTarjetaId;
		this.tipoMonedaId = tipoMonedaId;
		this.estado = estado;
		this.detalles = detalles;
	}
}
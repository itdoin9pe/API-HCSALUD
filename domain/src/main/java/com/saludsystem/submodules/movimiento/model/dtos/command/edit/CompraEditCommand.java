package com.saludsystem.submodules.movimiento.model.dtos.command.edit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraEditCommand extends BaseDTO
{
	private UUID compraId;
	private LocalDate fecha;
	private String tipoDocumento;
	private String nroDocumento;
	private UUID proveedorId;
	private UUID tipoPagoId;
	private UUID almacenId;

	@Schema(example = "0")
	private BigDecimal efectivo;

	private String guiaRemision;
	private String observacion;

	@Schema(example = "0")
	private Integer estado;

	private List<CompraDetalleEditCommand> detalles; // ✅
}
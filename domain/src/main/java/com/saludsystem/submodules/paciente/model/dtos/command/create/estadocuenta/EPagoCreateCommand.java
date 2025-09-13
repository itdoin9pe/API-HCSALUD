package com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EPagoCreateCommand
{
	private UUID pacEstadoCuentaId;

	private LocalDate fechaPago;

	@Schema(example = "0")
	private Double monto;

	private String metodoPago;

	private String referenciaPago;
}
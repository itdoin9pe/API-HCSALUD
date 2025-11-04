package com.saludsystem.submodules.paciente.model.dtos.get;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PConsentimientoDTO
{
	private UUID pacienteConsentimientoId;

	private UUID pacienteId;

	private UUID consentimientoId;

	private String cuerpo;

	private LocalDate fecha;

	private HoraDTO hora;

	private String apoderadoNombre;

	private String apoderadoDocumento;

	private String apoderadoDireccion;

	private UUID doctorId;

	@Schema(example = "0")
	private Integer estado;

	private byte[] firma;
}
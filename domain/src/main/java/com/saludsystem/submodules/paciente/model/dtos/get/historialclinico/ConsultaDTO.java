package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico;

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
public class ConsultaDTO
{
	protected UUID pacienteConsultaId;

	protected UUID pacienteId;

	protected UUID especialidadId;

	protected String motivoConsulta;

	protected String diagnosticoPresuntivo;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean tieneAlergia;
	protected String tieneAlergiaTexto;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean tomaMedicamento;
	protected String tomaMedicamentoTexto;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean cirugiasPrevias;
	
	protected String cirugiasPreviasTexto;
	protected String enfermedadesCronicas;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean transfusionesSanguineas;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean historialPsiquiatrico;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean fuma;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean consumeAlcohol;

	protected String actividadFisica;

	@Schema(description = "Valor boolean (true / false)", example = "s")
	protected boolean embarazada;

	protected LocalDate ultimaMenstruacion;
}
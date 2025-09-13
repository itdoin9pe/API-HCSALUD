package com.saludsystem.submodules.paciente.model.dtos.get;

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
public class MedicamentoRecetadoDTO
{
	private UUID medicamentoRecetadoId;

	private UUID pacienteRecetaId;

	private UUID medicamentoId;

	private String dosis;

	private String frecuencia;

	@Schema(example = "0")
	private Integer duracionDias;

	private String indicaciones;
}
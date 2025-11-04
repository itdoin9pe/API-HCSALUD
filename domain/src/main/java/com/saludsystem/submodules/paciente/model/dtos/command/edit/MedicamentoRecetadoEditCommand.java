package com.saludsystem.submodules.paciente.model.dtos.command.edit;

import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRecetadoEditCommand extends BaseDTO
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

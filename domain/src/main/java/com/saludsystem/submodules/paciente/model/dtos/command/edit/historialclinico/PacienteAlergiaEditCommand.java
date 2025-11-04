package com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico;

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
public class PacienteAlergiaEditCommand extends BaseDTO
{
	private UUID pacienteAlergiaId;
	private UUID pacienteId;
	private UUID alergiaId;
	private String observacion;

	@Schema(example = "0")
	private Integer estado;
}
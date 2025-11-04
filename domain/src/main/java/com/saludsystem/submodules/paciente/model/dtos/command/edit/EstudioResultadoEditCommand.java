package com.saludsystem.submodules.paciente.model.dtos.command.edit;

import java.time.LocalDateTime;

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
public class EstudioResultadoEditCommand extends BaseDTO
{
	@Schema(example = "Integer")
	private Long pacienteEstudioResultadoId;

	private String reporteTexto;
	private String urlImg;

	@Schema(example = "Integer")
	private Long pacienteEstudioMedicoId;

	private LocalDateTime createdAt;
}
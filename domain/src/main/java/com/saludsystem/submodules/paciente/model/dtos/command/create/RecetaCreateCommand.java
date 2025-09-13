package com.saludsystem.submodules.paciente.model.dtos.command.create;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecetaCreateCommand
{
	private UUID pacienteId;

	private LocalDate fecha;

	private UUID doctorId;

	private String observaciones;

	@Schema(example = "0")
	private Integer estado;

	private List<MedicamentoRecetadoDTO> medicamentos;
}
package com.saludsystem.submodules.catalogo.model.dto.command.edit;

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
public class EspecialidadEditCommand extends BaseDTO
{
	private UUID especialidadId;
	private String nombre;

	private String descripcion;

	@Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}
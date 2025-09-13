package com.saludsystem.submodules.operaciones.model.dtos.command.edit;

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
public class TipoMaterialEditCommand extends BaseDTO
{
	private String nombre;

	private String descripcion;

	@Schema(description = "Estado del tipo de material", example = "0")
	private Integer estado;
}

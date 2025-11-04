package com.saludsystem.submodules.movimiento.model.dtos.command.edit;

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
public class AlmacenEditCommand extends BaseDTO
{
	private UUID sedeId;

	private String nombre;

	@Schema(description = "Estado de almacen", example = "0")
	private Integer estado;

	private UUID sucursalId;
}

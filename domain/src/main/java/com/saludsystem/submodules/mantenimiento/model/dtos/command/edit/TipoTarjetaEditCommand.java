package com.saludsystem.submodules.mantenimiento.model.dtos.command.edit;

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
public class TipoTarjetaEditCommand extends BaseDTO
{
	private UUID tipoTarjetaId;

	private String descripcion;

	@Schema(description = "Estado de Tipo de tarjeta (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}
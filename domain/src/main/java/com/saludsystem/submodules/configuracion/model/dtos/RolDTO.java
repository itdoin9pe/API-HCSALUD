package com.saludsystem.submodules.configuracion.model.dtos;

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
public class RolDTO
{
	private UUID roleId;
	
	@Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
	
	private String nombre;
}
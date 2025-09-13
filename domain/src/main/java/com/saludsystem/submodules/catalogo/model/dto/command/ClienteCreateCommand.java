package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteCreateCommand
{
	private String tipoDocumento;

	private String nombre;

	private String direccion;

	private String contacto;

	@Schema(example = "999-888-555")
	private String telefono;

	@Schema(example = "user@gmail.com")
	private String email;

	@Schema(description = "Estado del Cliente (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}
package com.saludsystem.submodules.configuracion.model.dtos;

import java.util.Date;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClinicaDTO
{
	private UUID hospitalId;
	private String nombre;
	private String direccion;
	private String celular;

	@Email(message = "El email debe ser válido")
	private String email;

	private String ruc;
	private Date fecha;
	private String foto;
	private UUID planId;

	@Schema(example = "0")
	private Integer estado;
}
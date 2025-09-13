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
public class ConsentimientoEditCommand extends BaseDTO
{
	private UUID consentimientoId;
	private String nombre;

	private String observacion;

	private String texto;

	@Schema(description = "estado del consentimiento", example = "0")
	private Integer estado;
}
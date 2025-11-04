package com.saludsystem.submodules.principal.model.dtos.command.edit;

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
public class EstudioEditCommand extends BaseDTO
{
	private UUID estudioId;

	@Schema(description = "Descripción de estudio educativo", example = "string")
	private String descripcion;
}

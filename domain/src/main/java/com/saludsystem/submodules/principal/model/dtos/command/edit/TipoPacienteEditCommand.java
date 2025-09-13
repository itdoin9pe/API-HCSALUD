package com.saludsystem.submodules.principal.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;

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
public class TipoPacienteEditCommand extends BaseDTO
{
	private Long tipoPacienteId;

	private String nombre;
}

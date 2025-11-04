package com.saludsystem.submodules.configuracion.model.dtos.command.edit;

import java.util.UUID;

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
public class PermisoEditCommand extends BaseDTO
{
	private UUID permisoId;
	private UUID menuId;
	private UUID rolId;
	private Boolean read;
	private Boolean insert;
	private Boolean update;
	private Boolean delete;
}
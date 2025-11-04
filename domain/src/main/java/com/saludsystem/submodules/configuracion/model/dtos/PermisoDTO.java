package com.saludsystem.submodules.configuracion.model.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PermisoDTO
{
	private UUID permisoId;
	private UUID menuId;
	private UUID rolId;
	private Boolean read;
	private Boolean insert;
	private Boolean update;
	private Boolean delete;
}
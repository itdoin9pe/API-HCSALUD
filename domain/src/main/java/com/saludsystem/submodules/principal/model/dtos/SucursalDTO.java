package com.saludsystem.submodules.principal.model.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SucursalDTO
{
	private UUID sucursalId;
	private String nombre;
	private String direccion;
	private boolean isDefault;
}

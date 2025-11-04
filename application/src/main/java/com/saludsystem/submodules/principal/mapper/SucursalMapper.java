package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.Sucursal;
import com.saludsystem.submodules.principal.model.dtos.SucursalDTO;

public class SucursalMapper
{
	public SucursalDTO toDto(Sucursal model)
	{
		return new SucursalDTO(model.getSucursalId(), model.getNombre(), model.getDireccion(), model.isDefault());
	}
}
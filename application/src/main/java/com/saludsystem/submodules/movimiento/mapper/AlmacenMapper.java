package com.saludsystem.submodules.movimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.movimiento.model.dtos.AlmacenDTO;
import com.saludsystem.submodules.movimiento.model.dtos.command.AlmacenCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.AlmacenEditCommand;

public class AlmacenMapper {

	public Almacen fromCreateDto(AlmacenCreateCommand createCommand) {
		
		return new Almacen(null, createCommand.getNombre(), createCommand.getEstado(),
				createCommand.getSedeId(), createCommand.getSucursalId());
		
	}
	
	public Almacen fromUpdateDto(UUID uuid, AlmacenEditCommand editCommand) {
		
		return new Almacen(uuid, editCommand.getNombre(), editCommand.getEstado(),
				editCommand.getSedeId(), editCommand.getSucursalId());
		
	}
	
	public AlmacenDTO toDto(Almacen model) {
		
		return new AlmacenDTO(
				model.getAlmacenId(),
				model.getNombre(),
				model.getEstado(),
				model.getSedeId(),
				model.getSucursalId());
		
	}

}

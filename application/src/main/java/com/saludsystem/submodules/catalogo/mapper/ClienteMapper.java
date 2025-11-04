package com.saludsystem.submodules.catalogo.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ClienteEditCommand;

public class ClienteMapper
{
	public Cliente fromCreateDTO(ClienteCreateCommand dto)
	{
		return new Cliente(null, dto.getTipoDocumento(), dto.getNombre(), dto.getDireccion(), dto.getContacto(),
				dto.getEmail(), dto.getTipoDocumento(), dto.getEstado());
	}

	public Cliente fromUpdateDTO(UUID uuid, ClienteEditCommand dto)
	{
		return new Cliente(uuid, dto.getTipoDocumento(), dto.getNombre(), dto.getDireccion(), dto.getContacto(),
				dto.getEmail(), dto.getTipoDocumento(), dto.getEstado());
	}

	public ClienteDTO toDto(Cliente model)
	{
		return new ClienteDTO(model.getId(), model.getTipoDocumento(), model.getNombre(), model.getDireccion(),
				model.getContacto(), model.getEmail(), model.getTipoDocumento(), model.getEstado());
	}
}
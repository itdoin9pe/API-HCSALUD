package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ClienteEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

public class ClienteDboMapper
{
	public static ClienteEntity toEntity(Cliente model, UUID userId, UUID hospitalId)
	{
		ClienteEntity e = new ClienteEntity();
		e.setNombre(model.getNombre());
		e.setContacto(model.getContacto());
		e.setEmail(model.getEmail());
		e.setDireccion(model.getDireccion());
		e.setTelefono(model.getTelefono());
		e.setTipoDocumento(model.getTipoDocumento());
		e.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		e.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		e.setHospital(hospitalEntity);
		return e;
	}

	public static Cliente toDomain(ClienteEntity e)
	{
		return new Cliente(e.getClienteId(), e.getNombre(), e.getContacto(), e.getDireccion(), e.getTelefono(),
				e.getEmail(), e.getTipoDocumento(), e.getEstado());
	}
}
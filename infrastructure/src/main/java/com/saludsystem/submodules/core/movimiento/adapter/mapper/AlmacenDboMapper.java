package com.saludsystem.submodules.core.movimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.SucursalEntity;
import com.saludsystem.submodules.movimiento.model.Almacen;

public class AlmacenDboMapper {

	public static AlmacenEntity toEntity(Almacen model, UUID userId, UUID hospitalId) {
		
		AlmacenEntity entity = new AlmacenEntity();
		entity.setAlmacenId(model.getAlmacenId());
		entity.setNombre(model.getNombre());
		entity.setEstado(model.getEstado());
		
		SedeEntity sede = new SedeEntity();
		sede.setSedeId(model.getSedeId());
		entity.setSedeEntity(sede);
		
		SucursalEntity sucursal = new SucursalEntity();
		sucursal.setSucursalId(model.getSucursalId());
		entity.setSucursalEntity(sucursal);
	
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);
		
		return entity;
		
	}
	
	public static Almacen toDomain(AlmacenEntity entity) {
		return new Almacen(entity.getAlmacenId(), 
				entity.getNombre(), 
				entity.getEstado(), 
				entity.getSedeEntity().getSedeId(), 
				entity.getSucursalEntity().getSucursalId());
	}
	
	
}

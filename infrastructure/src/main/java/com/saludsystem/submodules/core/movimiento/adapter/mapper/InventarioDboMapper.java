package com.saludsystem.submodules.core.movimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.InventarioEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.MarcaEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;
import com.saludsystem.submodules.movimiento.model.Inventario;

public class InventarioDboMapper
{
	public static InventarioEntity toEntity(Inventario model, UUID hospitalId, UUID userId)
	{
		InventarioEntity entity = new InventarioEntity();
		entity.setInventarioId(model.getId());
		AlmacenEntity almacen = new AlmacenEntity();
		almacen.setAlmacenId(model.getAlmacenId());
		entity.setAlmacenEntity(almacen);
		entity.setTipoInventarioId(model.getTipoInventarioId());
		ProductoEntity producto = new ProductoEntity();
		producto.setProductoId(model.getProductoId());
		entity.setProductoEntity(producto);
		MarcaEntity marca = new MarcaEntity();
		marca.setMarcaMaterialesId(model.getMarcaId());
		entity.setMarcaMaterialEntity(marca);
		UnidadEntity unidad = new UnidadEntity();
		unidad.setUnidadId(model.getUnidadId());
		entity.setUnidadEntity(unidad);
		entity.setPrecioEntrada(model.getPrecioEntrada());
		entity.setPrecioSalida(model.getPrecioSalida());
		entity.setStock(model.getStock());
		entity.setFecha(model.getFecha());
		entity.setEstado(model.getEstado());
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);
		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);
		return entity;
	}

	public static Inventario toDomain(InventarioEntity entity)
	{
		return new Inventario(entity.getInventarioId(), entity.getAlmacenEntity().getAlmacenId(),
				entity.getTipoInventarioId(), entity.getProductoEntity().getProductoId(),
				entity.getMarcaMaterialEntity().getMarcaMaterialesId(),
				entity.getCategoriaMatEntity().getCategoriaMaterialId(), entity.getUnidadEntity().getUnidadId(),
				entity.getPrecioEntrada(), entity.getPrecioSalida(), entity.getStock(), entity.getFecha(),
				entity.getEstado());
	}
}
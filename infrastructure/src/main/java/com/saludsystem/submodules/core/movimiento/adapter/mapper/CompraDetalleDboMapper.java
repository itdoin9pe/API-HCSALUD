package com.saludsystem.submodules.core.movimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraDetalleEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;

public class CompraDetalleDboMapper
{
	public static CompraDetalleEntity toEntity(
		CompraDetalle model,
		CompraEntity compraEntity,
		UUID hospitalId,
		UUID userId)
	{
		CompraDetalleEntity entity = new CompraDetalleEntity();
		entity.setCompraDetalleId(model.getCompraDetalleId());
		entity.setCompraEntity(compraEntity);

		ProductoEntity producto = new ProductoEntity();
		producto.setProductoId(model.getProductoId());
		entity.setProductoEntity(producto);

		entity.setCantidad(model.getCantidad());
		entity.setPrecioUnitario(model.getPrecioUnitario());
		entity.setIgv(model.getIgv());
		entity.setPrecioVenta(model.getPrecioVenta());
		entity.setSubtotal(model.getSubtotal());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static CompraDetalle toDomain(CompraDetalleEntity entity)
	{
		return new CompraDetalle(entity.getCompraDetalleId(), entity.getCompraEntity().getCompraId(),
				entity.getProductoEntity().getProductoId(), entity.getCantidad(), entity.getPrecioUnitario(),
				entity.getIgv(), entity.getPrecioVenta(), entity.getSubtotal());
	}
}

package com.saludsystem.submodules.core.movimiento.adapter.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraDetalleEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProveedorEntity;
import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;

public class CompraDboMapper
{
	public static CompraEntity toEntity(Compra model, UUID hospitalId, UUID userId)
	{
		CompraEntity entity = new CompraEntity();
		entity.setCompraId(model.getCompraId());
		entity.setFecha(model.getFecha());
		entity.setTipoDocumento(model.getTipoDocumento());
		entity.setNroDocumento(model.getNroDocumento());

		ProveedorEntity proveedor = new ProveedorEntity();
		proveedor.setProveedorId(model.getProveedorId());
		entity.setProveedorEntity(proveedor);

		TipoPagoEntity tipoPago = new TipoPagoEntity();
		tipoPago.setTipoPagoId(model.getTipoPagoId());
		entity.setTipoPagoEntity(tipoPago);

		AlmacenEntity almacen = new AlmacenEntity();
		almacen.setAlmacenId(model.getAlmacenId());
		entity.setAlmacenEntity(almacen);

		entity.setEfectivo_total(model.getEfectivoTotal());
		entity.setGuiaRemision(model.getGuiaRemision());
		entity.setObservacion(model.getObservacion());
		entity.setEstado(model.getEstado());

		List<CompraDetalleEntity> detalleEntities = model.getDetalles().stream()
				.map(det -> CompraDetalleDboMapper.toEntity(det, entity, hospitalId, userId))
				.collect(Collectors.toList());
		entity.setDetalle(detalleEntities);

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static Compra toDomain(CompraEntity entity)
	{
		List<CompraDetalle> detalles = entity.getDetalle().stream().map(CompraDetalleDboMapper::toDomain)
				.collect(Collectors.toList());
		return new Compra(entity.getCompraId(), entity.getFecha(), entity.getTipoDocumento(), entity.getNroDocumento(),
				entity.getProveedorEntity().getProveedorId(), entity.getTipoPagoEntity().getTipoPagoId(),
				entity.getAlmacenEntity().getAlmacenId(), entity.getEfectivo_total(), entity.getGuiaRemision(),
				entity.getObservacion(), entity.getEstado(), detalles);
	}
}

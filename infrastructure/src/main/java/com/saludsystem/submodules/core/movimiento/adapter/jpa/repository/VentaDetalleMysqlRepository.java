package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.movimiento.adapter.entity.VentaDetalleEntity;
import com.saludsystem.submodules.core.movimiento.adapter.jpa.VentaDetalleJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.VentaDetalleDboMapper;
import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.model.constant.VentaDetalleConstant;
import com.saludsystem.submodules.movimiento.port.repository.VentaDetalleRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class VentaDetalleMysqlRepository implements VentaDetalleRepository {

	private final VentaDetalleJpaRepository ventaDetalleJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;
	
	/**
	 * @param ventaDetalleJpaRepository
	 * @param authenticateUserPort
	 */
	public VentaDetalleMysqlRepository(VentaDetalleJpaRepository ventaDetalleJpaRepository,
			AuthenticateUserPort authenticateUserPort) {
		this.ventaDetalleJpaRepository = ventaDetalleJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public VentaDetalle save(VentaDetalle ventaDetalle) {
		// TODO Auto-generated method stub
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		VentaDetalleEntity entity = VentaDetalleDboMapper.toEntity(ventaDetalle, hospitalId, userId);
		return VentaDetalleDboMapper.toDomain(ventaDetalleJpaRepository.save(entity));
	}

	@Override
	public VentaDetalle update(UUID uuid, VentaDetalle ventaDetalle) {
		// TODO Auto-generated method stub
		if (ventaDetalleJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(VentaDetalleConstant.ID_NOT_FOUND);
		}
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		VentaDetalleEntity entity = VentaDetalleDboMapper.toEntity(ventaDetalle, hospitalId, userId);
		return VentaDetalleDboMapper.toDomain(ventaDetalleJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid) {
		// TODO Auto-generated method stub
		if (ventaDetalleJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(VentaDetalleConstant.ID_NOT_FOUND);
		}
		ventaDetalleJpaRepository.deleteById(uuid);
	}

}

package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.movimiento.adapter.entity.VentaEntity;
import com.saludsystem.submodules.core.movimiento.adapter.jpa.VentaJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.VentaDboMapper;
import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.model.constant.VentaConstant;
import com.saludsystem.submodules.movimiento.port.repository.VentaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class VentaMysqlRepository implements VentaRepository
{
	private final VentaJpaRepository ventaJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public VentaMysqlRepository(VentaJpaRepository ventaJpaRepository, AuthenticateUserPort authenticateUserPort)
	{
		this.ventaJpaRepository = ventaJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Venta save(Venta venta)
	{
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		VentaEntity entity = VentaDboMapper.toEntity(venta, hospitalId, userId);
		return VentaDboMapper.toDomain(ventaJpaRepository.save(entity));
	}

	@Override
	public Venta update(UUID uuid, Venta venta)
	{
		if (!ventaJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(VentaConstant.ID_NOT_FOUND);
		}
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		VentaEntity entity = VentaDboMapper.toEntity(venta, hospitalId, userId);
		return VentaDboMapper.toDomain(ventaJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		ventaJpaRepository.deleteById(uuid);
	}
}

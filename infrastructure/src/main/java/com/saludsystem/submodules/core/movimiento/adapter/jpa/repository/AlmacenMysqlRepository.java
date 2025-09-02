package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;
import com.saludsystem.submodules.core.movimiento.adapter.jpa.AlmacenJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.AlmacenDboMapper;
import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.movimiento.port.repository.AlmacenRepository;

@Component
public class AlmacenMysqlRepository implements AlmacenRepository {

	private final AlmacenJpaRepository almacenJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;
	
	/**
	 * @param almacenJpaRepository
	 * @param authenticateUserPort
	 */
	public AlmacenMysqlRepository(AlmacenJpaRepository almacenJpaRepository,
			AuthenticateUserPort authenticateUserPort) {
		this.almacenJpaRepository = almacenJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Almacen save(Almacen almacen) {
		// TODO Auto-generated method stub
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		AlmacenEntity entity = AlmacenDboMapper.toEntity(almacen, userId, hospitalId);
		return AlmacenDboMapper.toDomain(almacenJpaRepository.save(entity));
	}

	@Override
	public Almacen update(UUID uuid, Almacen almacen) {
		// TODO Auto-generated method stub
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		AlmacenEntity entity = AlmacenDboMapper.toEntity(almacen, userId, hospitalId);
		return AlmacenDboMapper.toDomain(almacenJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid) {
		// TODO Auto-generated method stub
		almacenJpaRepository.deleteById(uuid);
	}
	
	
	
}

package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.movimiento.adapter.entity.InventarioEntity;
import com.saludsystem.submodules.core.movimiento.adapter.jpa.InventarioJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.InventarioDboMapper;
import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.model.constant.InventarioConstant;
import com.saludsystem.submodules.movimiento.port.repository.InventarioRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InventarioMysqlRepository implements InventarioRepository {
	
	private final InventarioJpaRepository inventarioJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;
	
    /**
	 * @param inventarioJpaRepository
	 * @param authenticateUserPort
	 */
	public InventarioMysqlRepository(InventarioJpaRepository inventarioJpaRepository,
			AuthenticateUserPort authenticateUserPort) {
		this.inventarioJpaRepository = inventarioJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
    public Inventario save(Inventario inventario) {
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		InventarioEntity entity = InventarioDboMapper.toEntity(inventario, hospitalId, userId);
        return InventarioDboMapper.toDomain(inventarioJpaRepository.save(entity));
    }

    @Override
    public Inventario update(UUID uuid, Inventario inventario) {
    	if (inventarioJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(InventarioConstant.ID_NOT_FOUND);
		}
    	UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		InventarioEntity entity = InventarioDboMapper.toEntity(inventario, hospitalId, userId);
        return InventarioDboMapper.toDomain(inventarioJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
     	if (inventarioJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(InventarioConstant.ID_NOT_FOUND);
		}
     	inventarioJpaRepository.deleteById(uuid);
    }
}
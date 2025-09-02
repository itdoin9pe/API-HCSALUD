package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.MarcaEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.MarcaJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.MarcaDboMapper;
import com.saludsystem.submodules.operaciones.model.constant.MarcaConstant;
import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MarcaMysqlRepository implements MarcaRepository {

    private final MarcaJpaRepository marcaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public MarcaMysqlRepository(MarcaJpaRepository marcaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.marcaJpaRepository = marcaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Marca save(Marca marca) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MarcaEntity entity = MarcaDboMapper.toEntity(marca, userId, hospitalId);
        return MarcaDboMapper.toDomain(marcaJpaRepository.save(entity));
    }

    @Override
    public Marca update(UUID uuid, Marca marca) {
        if (!marcaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(MarcaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MarcaEntity entity = MarcaDboMapper.toEntity(marca, userId, hospitalId);
        return MarcaDboMapper.toDomain(marcaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!marcaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(MarcaConstant.ID_NOT_FOUND);
        }
        marcaJpaRepository.deleteById(uuid);
    }
}

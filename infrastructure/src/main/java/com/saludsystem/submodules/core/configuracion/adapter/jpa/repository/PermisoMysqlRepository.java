package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.port.in.repository.PermisoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.configuracion.adapter.entity.PermisoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.PermisoJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.PermisoDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PermisoMysqlRepository implements PermisoRepository {

    private final PermisoJpaRepository permisoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public PermisoMysqlRepository(PermisoJpaRepository permisoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.permisoJpaRepository = permisoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Permiso save(Permiso permiso) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PermisoEntity entity = PermisoDboMapper.toEntity(permiso, userId, hospitalId);
        return PermisoDboMapper.toDomain(permisoJpaRepository.save(entity));
    }

    @Override
    public Permiso update(UUID uuid, Permiso permiso) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PermisoEntity entity = PermisoDboMapper.toEntity(permiso, userId, hospitalId);
        return PermisoDboMapper.toDomain(permisoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        permisoJpaRepository.deleteById(uuid);
    }

}

package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.PresentacionEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.PresentacionJpaReposirory;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.PresentacionDboMapper;
import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.operaciones.port.repository.PresentacionRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PresentacionMysqlRepository implements PresentacionRepository {

    private final PresentacionJpaReposirory presentacionJpaReposirory;
    private final AuthenticateUserPort authenticateUserPort;

    public PresentacionMysqlRepository(PresentacionJpaReposirory presentacionJpaReposirory, AuthenticateUserPort authenticateUserPort) {
        this.presentacionJpaReposirory = presentacionJpaReposirory;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Presentacion save(Presentacion presentacion) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PresentacionEntity entity = PresentacionDboMapper.toEntity(presentacion, userId, hospitalId);
        return PresentacionDboMapper.toDomain(presentacionJpaReposirory.save(entity));
    }

    @Override
    public Presentacion update(UUID uuid, Presentacion presentacion) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PresentacionEntity entity = PresentacionDboMapper.toEntity(presentacion, userId, hospitalId);
        return PresentacionDboMapper.toDomain(presentacionJpaReposirory.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        presentacionJpaReposirory.deleteById(uuid);
    }
}

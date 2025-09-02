package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ConsentimientoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ConsentimientoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ConsentimientoDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoMysqlRepository implements ConsentimientoRepository {

    private final ConsentimientoJpaRepository consentimientoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ConsentimientoMysqlRepository(ConsentimientoJpaRepository consentimientoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.consentimientoJpaRepository = consentimientoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Consentimiento save(Consentimiento consentimiento) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ConsentimientoEntity entity = ConsentimientoDboMapper.toEntity(consentimiento, userId, hospitalId);
        return ConsentimientoDboMapper.toDomain(consentimientoJpaRepository.save(entity));
    }

    @Override
    public Consentimiento update(UUID uuid, Consentimiento consentimiento) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ConsentimientoEntity entity = ConsentimientoDboMapper.toEntity(consentimiento, userId, hospitalId);
        return ConsentimientoDboMapper.toDomain(consentimientoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        consentimientoJpaRepository.deleteById(uuid);
    }
}

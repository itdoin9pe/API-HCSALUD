package com.saludsystem.submodules.core.principal.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.principal.adapter.entity.PaisEntity;
import com.saludsystem.submodules.core.principal.adapter.jpa.PaisJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.PaisDboMapper;
import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaisMysqlRepository implements PaisRepository {

    private final PaisJpaRepository paisJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public PaisMysqlRepository(PaisJpaRepository paisJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.paisJpaRepository = paisJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Pais save(Pais pais) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PaisEntity entity = PaisDboMapper.toEntity(pais, userId, hospitalId);
        return PaisDboMapper.toDomain(paisJpaRepository.save(entity));
    }

    @Override
    public Pais update(Integer id, Pais pais) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PaisEntity entity = PaisDboMapper.toEntity(pais, userId, hospitalId);
        return PaisDboMapper.toDomain(paisJpaRepository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        paisJpaRepository.deleteById(id);
    }

}

package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.AlergiaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.AlergiaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.AlergiaDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaMysqlRepository implements AlergiaRepository {

    private final AlergiaJpaRepository alergiaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public AlergiaMysqlRepository(AlergiaJpaRepository alergiaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.alergiaJpaRepository = alergiaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Alergia save(Alergia alergia) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        AlergiaEntity entity = AlergiaDboMapper.toEntity(alergia, userId, hospitalId);
        return AlergiaDboMapper.toDomain(alergiaJpaRepository.save(entity));
    }

    @Override
    public Alergia update(UUID id, Alergia alergia) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        AlergiaEntity entity = AlergiaDboMapper.toEntity(alergia, userId, hospitalId);
        return AlergiaDboMapper.toDomain(alergiaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID id) {
        alergiaJpaRepository.deleteById(id);
    }
}

package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.configuracion.port.in.repository.SysSaludRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.SysSaludJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.ClinicaDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClinicaMysqlRepository implements SysSaludRepository {

    private final SysSaludJpaRepository sysSaludJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ClinicaMysqlRepository(SysSaludJpaRepository sysSaludJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.sysSaludJpaRepository = sysSaludJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public SysSalud save(SysSalud sysSalud) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        SysSaludEntity entity = ClinicaDboMapper.toEntity(sysSalud, hospitalId);
        return ClinicaDboMapper.toDomain(sysSaludJpaRepository.save(entity));
    }

    @Override
    public SysSalud update(UUID uuid, SysSalud sysSalud) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        SysSaludEntity entity = ClinicaDboMapper.toEntity(sysSalud, hospitalId);
        return ClinicaDboMapper.toDomain(sysSaludJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        sysSaludJpaRepository.deleteById(uuid);
    }
}

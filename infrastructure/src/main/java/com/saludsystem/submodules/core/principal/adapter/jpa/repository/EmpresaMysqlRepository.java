package com.saludsystem.submodules.core.principal.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.principal.adapter.entity.EmpresaEntity;
import com.saludsystem.submodules.core.principal.adapter.jpa.EmpresaJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.EmpresaDboMapper;
import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmpresaMysqlRepository implements EmpresaRepository {

    private final EmpresaJpaRepository empresaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EmpresaMysqlRepository(EmpresaJpaRepository empresaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.empresaJpaRepository = empresaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Empresa save(Empresa empresa) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EmpresaEntity entity = EmpresaDboMapper.toEntity(empresa, userId, hospitalId);
        return EmpresaDboMapper.toDomain(empresaJpaRepository.save(entity));
    }

    @Override
    public Empresa update(UUID uuid, Empresa empresa) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EmpresaEntity entity = EmpresaDboMapper.toEntity(empresa, userId, hospitalId);
        return EmpresaDboMapper.toDomain(empresaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        empresaJpaRepository.deleteById(uuid);
    }
}

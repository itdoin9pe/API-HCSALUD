package com.saludsystem.submodules.core.principal.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.principal.adapter.entity.InformacionClinicaEntity;
import com.saludsystem.submodules.core.principal.adapter.jpa.InformacionClinicaJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.InformacionClinicaDboMapper;
import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformacionClinicaMysqlRepository implements InformacionClinicaRepository {

    private final InformacionClinicaJpaRepository informacionClinicaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public InformacionClinicaMysqlRepository(InformacionClinicaJpaRepository informacionClinicaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.informacionClinicaJpaRepository = informacionClinicaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public InformacionClinica save(InformacionClinica informacionClinica) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        InformacionClinicaEntity entity = InformacionClinicaDboMapper.toEntity(informacionClinica, userId, hospitalId);
        return InformacionClinicaDboMapper.toDomain(informacionClinicaJpaRepository.save(entity));
    }

    @Override
    public InformacionClinica update(UUID uuid, InformacionClinica informacionClinica) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        InformacionClinicaEntity entity = InformacionClinicaDboMapper.toEntity(informacionClinica, userId, hospitalId);
        return InformacionClinicaDboMapper.toDomain(informacionClinicaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        informacionClinicaJpaRepository.deleteById(uuid);
    }
}

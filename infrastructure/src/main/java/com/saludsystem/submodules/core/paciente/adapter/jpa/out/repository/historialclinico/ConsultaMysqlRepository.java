package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.historialclinico;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.ConsultaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.ConsultaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.ConsultaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ConsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ConsultaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsultaMysqlRepository implements ConsultaRepository {

    private final ConsultaJpaRepository consultaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ConsultaMysqlRepository(ConsultaJpaRepository consultaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.consultaJpaRepository = consultaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Consulta save(Consulta consulta) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ConsultaEntity entity = ConsultaDboMapper.toEntity(consulta, userId, hospitalId);
        return ConsultaDboMapper.toDomain(consultaJpaRepository.save(entity));
    }

    @Override
    public Consulta update(UUID uuid, Consulta consulta) {
        if (!consultaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(ConsultaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ConsultaEntity entity = ConsultaDboMapper.toEntity(consulta, userId, hospitalId);
        return ConsultaDboMapper.toDomain(consultaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!consultaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(ConsultaConstant.ID_NOT_FOUND);
        }
        consultaJpaRepository.deleteById(uuid);
    }

}

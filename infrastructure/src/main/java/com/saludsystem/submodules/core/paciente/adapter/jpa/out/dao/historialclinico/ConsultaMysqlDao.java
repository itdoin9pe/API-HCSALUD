package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.historialclinico;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.ConsultaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.ConsultaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ConsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsultaMysqlDao implements ConsultaDao {

    private final ConsultaJpaRepository consultaJpaRepository;

    public ConsultaMysqlDao(ConsultaJpaRepository consultaJpaRepository) {
        this.consultaJpaRepository = consultaJpaRepository;
    }

    @Override
    public Consulta getById(UUID uuid) {
        return consultaJpaRepository.findById(uuid)
                .map(ConsultaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(ConsultaConstant.INVALID_ID));
    }

    @Override
    public ListResponse<Consulta> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = consultaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Consulta> data = pageResult.getContent()
                .stream()
                .map(ConsultaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Consulta> getList() {
        return consultaJpaRepository.findAll()
                .stream()
                .map(ConsultaDboMapper::toDomain)
                .toList();
    }

}

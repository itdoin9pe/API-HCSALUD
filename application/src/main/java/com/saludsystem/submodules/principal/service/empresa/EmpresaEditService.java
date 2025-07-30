package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.dtos.put.ActualizarEmpresaDTO;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;

import java.util.UUID;

public class EmpresaEditService {

    private final EmpresaRepository empresaRepository;

    public EmpresaEditService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa execute(UUID uuid, ActualizarEmpresaDTO dto) {

        var updated = EmpresaMapper.fromUpdateDto(uuid, dto);

        return empresaRepository.update(uuid, updated);

    }
}

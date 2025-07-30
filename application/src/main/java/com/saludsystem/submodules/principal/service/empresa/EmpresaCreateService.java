package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.dtos.post.CrearEmpresaDTO;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;

public class EmpresaCreateService {

    private final EmpresaRepository empresaRepository;

    public EmpresaCreateService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa execute(CrearEmpresaDTO dto) {

        var empresaToSave = EmpresaMapper.fromCreateDto(dto);

        return empresaRepository.save(empresaToSave);

    }
}

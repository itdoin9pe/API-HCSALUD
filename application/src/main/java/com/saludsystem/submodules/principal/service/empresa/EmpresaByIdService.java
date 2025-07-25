package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;

import java.util.UUID;

public class EmpresaByIdService {

    private final EmpresaDao empresaDao;

    public EmpresaByIdService(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }

    public EmpresaDTO execute(UUID uuid) {
        return EmpresaMapper.toDto(empresaDao.getById(uuid));
    }
}

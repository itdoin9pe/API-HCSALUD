package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;

import java.util.List;

public class EmpresaListService {

    private final EmpresaDao empresaDao;

    public EmpresaListService(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }

    public List<EmpresaDTO> execute() {
        return empresaDao.getList()
                .stream()
                .map(EmpresaMapper::toDto)
                .toList();
    }
}

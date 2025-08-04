package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.model.dtos.EmpresaDTO;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaListHandler {

    private final EmpresaDao empresaDao;
    private final EmpresaMapper empresaMapper;

    public EmpresaListHandler(EmpresaDao empresaDao, EmpresaMapper empresaMapper) {
        this.empresaDao = empresaDao;
        this.empresaMapper = empresaMapper;
    }

    public List<EmpresaDTO> execute() {

        List<Empresa> empresaList = empresaDao.getList();

        return empresaList.stream()
                .map(empresaMapper::toDto)
                .toList();

    }

}

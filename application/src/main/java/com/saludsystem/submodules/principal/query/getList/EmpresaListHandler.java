package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.model.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.service.empresa.EmpresaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaListHandler {

    private final EmpresaListService empresaListService;

    public EmpresaListHandler(EmpresaListService empresaListService) {
        this.empresaListService = empresaListService;
    }

    public List<EmpresaDTO> execute() {
        return empresaListService.execute();
    }

}

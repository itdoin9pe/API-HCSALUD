package com.saludsystem.submodules.operaciones.query.getList;

import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.service.marca.MarcaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcaListHandler {

    private final MarcaListService marcaListService;

    public MarcaListHandler(MarcaListService marcaListService) {
        this.marcaListService = marcaListService;
    }

    public List<MarcaDTO> execute() {
        return marcaListService.execute();
    }

}

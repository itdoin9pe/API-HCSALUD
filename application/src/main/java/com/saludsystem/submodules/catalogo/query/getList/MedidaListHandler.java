package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.service.medida.MedidaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedidaListHandler {

    private final MedidaListService medidaListService;

    public MedidaListHandler(MedidaListService medidaListService) {
        this.medidaListService = medidaListService;
    }

    public List<MedidaDTO> execute() {
        return medidaListService.execute();
    }
}

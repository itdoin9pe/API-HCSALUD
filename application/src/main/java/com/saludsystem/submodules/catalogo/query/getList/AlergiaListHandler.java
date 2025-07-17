package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlergiaListHandler {

    private final AlergiaListService alergiaListService;

    public AlergiaListHandler(AlergiaListService alergiaListService) {
        this.alergiaListService = alergiaListService;
    }

    public List<AlergiaDTO> execute() {
        return alergiaListService.execute();
    }
}

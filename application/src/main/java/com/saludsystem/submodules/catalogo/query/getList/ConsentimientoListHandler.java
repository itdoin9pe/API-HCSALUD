package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsentimientoListHandler {

    private final ConsentimientoListService consentimientoListService;

    public ConsentimientoListHandler(ConsentimientoListService consentimientoListService) {
        this.consentimientoListService = consentimientoListService;
    }

    public List<ConsentimientoDTO> execute() {
        return consentimientoListService.execute();
    }
}

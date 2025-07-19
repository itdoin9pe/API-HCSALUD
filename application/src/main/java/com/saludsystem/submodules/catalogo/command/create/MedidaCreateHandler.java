package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedidaDTO;
import com.saludsystem.submodules.catalogo.service.medida.MedidaCreateService;
import org.springframework.stereotype.Component;

@Component
public class MedidaCreateHandler {

    private final MedidaCreateService medidaCreateService;

    public MedidaCreateHandler(MedidaCreateService medidaCreateService) {
        this.medidaCreateService = medidaCreateService;
    }

    public void execute(CrearMedidaDTO dto) {
        medidaCreateService.execute(dto);
    }
}

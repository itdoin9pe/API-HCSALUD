package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearCajaDTO;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaCreateService;
import org.springframework.stereotype.Component;

@Component
public class CajaCreateHandler {

    private final CajaCreateService cajaCreateService;

    public CajaCreateHandler(CajaCreateService cajaCreateService) {
        this.cajaCreateService = cajaCreateService;
    }

    public void execute(CrearCajaDTO dto) {
        cajaCreateService.execute(dto);
    }
}

package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.dtos.command.CrearMarcaDTO;
import com.saludsystem.submodules.operaciones.service.marca.MarcaCreateService;
import org.springframework.stereotype.Component;

@Component
public class MarcaCreateHandler {

    private final MarcaCreateService marcaCreateService;

    public MarcaCreateHandler(MarcaCreateService marcaCreateService) {
        this.marcaCreateService = marcaCreateService;
    }

    public void execute(CrearMarcaDTO dto) {
        marcaCreateService.execute(dto);
    }

}

package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.dtos.post.CrearAseguradoraDTO;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraCreateService;
import org.springframework.stereotype.Component;

@Component
public class AseguradoraCreateHandler {

    private final AseguradoraCreateService aseguradoraCreateService;

    public AseguradoraCreateHandler(AseguradoraCreateService aseguradoraCreateService) {
        this.aseguradoraCreateService = aseguradoraCreateService;
    }

    public void execute(CrearAseguradoraDTO dto) {
        aseguradoraCreateService.execute(dto);
    }

}

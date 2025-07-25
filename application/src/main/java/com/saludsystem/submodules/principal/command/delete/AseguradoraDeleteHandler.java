package com.saludsystem.submodules.principal.command.delete;

import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AseguradoraDeleteHandler {

    private final AseguradoraDeleteService aseguradoraDeleteService;

    public AseguradoraDeleteHandler(AseguradoraDeleteService aseguradoraDeleteService) {
        this.aseguradoraDeleteService = aseguradoraDeleteService;
    }

    public void execute(UUID uuid) {
        aseguradoraDeleteService.execute(uuid);
    }

}

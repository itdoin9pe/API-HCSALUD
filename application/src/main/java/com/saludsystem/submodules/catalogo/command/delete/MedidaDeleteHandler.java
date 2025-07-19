package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.medida.MedidaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaDeleteHandler {

    private final MedidaDeleteService medidaDeleteService;

    public MedidaDeleteHandler(MedidaDeleteService medidaDeleteService) {
        this.medidaDeleteService = medidaDeleteService;
    }

    public void execute(UUID uuid) {
        medidaDeleteService.execute(uuid);
    }
}

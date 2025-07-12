package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.MedidaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaDeleteHandler {
    private final MedidaService medidaService;

    public MedidaDeleteHandler(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    public void execute(UUID uuid) {
        medidaService.delete(uuid);
    }
}

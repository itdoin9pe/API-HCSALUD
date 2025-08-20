package com.saludsystem.submodules.movimiento.command.delete;

import com.saludsystem.submodules.movimiento.service.compra.CompraDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDeleteHandler {

    private final CompraDeleteService compraDeleteService;

    public CompraDeleteHandler(CompraDeleteService compraDeleteService) {
        this.compraDeleteService = compraDeleteService;
    }

    public void execute(UUID uuid) {

        compraDeleteService.execute(uuid);

    }

}

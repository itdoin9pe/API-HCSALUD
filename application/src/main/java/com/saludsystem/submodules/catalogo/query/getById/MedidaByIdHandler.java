package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.service.medida.MedidaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaByIdHandler {

    private final MedidaByIdService medidaByIdService;

    public MedidaByIdHandler(MedidaByIdService medidaByIdService) {
        this.medidaByIdService = medidaByIdService;
    }

    public MedidaDTO execute(UUID uuid) {
        return medidaByIdService.execute(uuid);
    }
}

package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.MedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.in.service.MedidaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaByIdHandler {
    private final MedidaService medidaService;

    public MedidaByIdHandler(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    public MedidaDTO execute(UUID uuid) {
        Medida model = medidaService.getById(uuid);
        return MedidaMapper.toDto(model);
    }
}

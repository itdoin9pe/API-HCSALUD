package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.MedidaDTO;
import com.saludsystem.application.catalogo.mapper.MedidaMapper;
import com.saludsystem.domain.catalogo.model.Medida;
import com.saludsystem.domain.catalogo.port.in.service.MedidaService;
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

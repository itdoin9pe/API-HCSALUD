package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarMedidaDTO;
import com.saludsystem.application.catalogo.mapper.MedidaMapper;
import com.saludsystem.domain.catalogo.port.in.service.MedidaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaEditHandler {
    private final MedidaService medidaService;

    public MedidaEditHandler(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    public void execute(UUID uuid, ActualizarMedidaDTO dto) {
        medidaService.update(uuid, MedidaMapper.fromUpdateDto(uuid, dto));
    }
}

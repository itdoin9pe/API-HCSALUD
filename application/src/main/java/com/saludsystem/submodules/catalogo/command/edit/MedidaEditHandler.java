package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarMedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.port.in.service.MedidaService;
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

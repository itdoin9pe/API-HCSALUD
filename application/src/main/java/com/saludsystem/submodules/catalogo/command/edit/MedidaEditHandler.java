package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.MedidaEditCommand;
import com.saludsystem.submodules.catalogo.service.medida.MedidaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaEditHandler {

    private final MedidaEditService medidaEditService;
    private final MedidaMapper medidaMapper;

    public MedidaEditHandler(MedidaEditService medidaEditService, MedidaMapper medidaMapper) {
        this.medidaEditService = medidaEditService;
        this.medidaMapper = medidaMapper;
    }

    public void execute(UUID uuid, MedidaEditCommand editCommand) {

        var medida = medidaMapper.fromUpdateDto(uuid, editCommand);

        medidaEditService.execute(uuid, medida);

    }

}

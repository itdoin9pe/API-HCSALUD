package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.MonedadEditCommand;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonedaEditHandler {

    private final MonedaEditService monedaEditService;
    private final MonedaMapper monedaMapper;

    public MonedaEditHandler(MonedaEditService monedaEditService, MonedaMapper monedaMapper) {
        this.monedaEditService = monedaEditService;
        this.monedaMapper = monedaMapper;
    }

    public void execute(UUID uuid, MonedadEditCommand editCommand) {

        var moneda = monedaMapper.fromUpdateDto(uuid, editCommand);

        monedaEditService.execute(uuid, moneda);

    }

}

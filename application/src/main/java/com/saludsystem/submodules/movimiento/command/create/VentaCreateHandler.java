package com.saludsystem.submodules.movimiento.command.create;

import com.saludsystem.submodules.movimiento.mapper.VentaMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.VentaCreateCommand;
import com.saludsystem.submodules.movimiento.service.venta.VentaCreateService;
import org.springframework.stereotype.Component;

@Component
public class VentaCreateHandler {

    private final VentaCreateService ventaCreateService;
    private final VentaMapper ventaMapper;

    public VentaCreateHandler(VentaCreateService ventaCreateService, VentaMapper ventaMapper) {
        this.ventaCreateService = ventaCreateService;
        this.ventaMapper = ventaMapper;
    }

    public void execute(VentaCreateCommand createCommand) {

        var ventaCreated = ventaMapper.fromCreateDto(createCommand);

        ventaCreateService.execute(ventaCreated);

    }

}

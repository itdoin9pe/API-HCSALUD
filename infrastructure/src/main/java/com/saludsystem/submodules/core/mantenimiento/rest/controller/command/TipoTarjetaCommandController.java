package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.TipoTarjetaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TipoTarjetaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TipoTarjetaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoTarjetaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoTarjetaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoTarjetaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaCommandController {

    private final TipoTarjetaCreateHandler createHandler;
    private final TipoTarjetaEditHandler editHandler;
    private final TipoTarjetaDeleteHandler deleteHandler;

    public TipoTarjetaCommandController(TipoTarjetaCreateHandler createHandler, TipoTarjetaEditHandler editHandler, TipoTarjetaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody TipoTarjetaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TipoTarjetaConstant.CREATED);
    }

    @PutMapping("/Update/{tipoTarjetaId}")
    public ApiResponse update(@PathVariable UUID tipoTarjetaId, @RequestBody TipoTarjetaEditCommand dto) {
        editHandler.execute(tipoTarjetaId, dto);
        return new ApiResponse(true, TipoTarjetaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{tipoTarjetaId}")
    public ApiResponse delete(@PathVariable UUID tipoTarjetaId) {
        deleteHandler.execute(tipoTarjetaId);
        return new ApiResponse(true, TipoTarjetaConstant.DELETED);
    }

}
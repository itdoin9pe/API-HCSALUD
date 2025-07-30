package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.TipoTarjetaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TipoTarjetaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TipoTarjetaEditHandler;
import com.saludsystem.submodules.mantenimiento.constant.TipoTarjetaConstant;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarTipoTarjetaDTO;
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
    public ApiResponse save(@RequestBody CrearTipoTarjetaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TipoTarjetaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarTipoTarjetaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, TipoTarjetaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, TipoTarjetaConstant.DELETED);
    }

}
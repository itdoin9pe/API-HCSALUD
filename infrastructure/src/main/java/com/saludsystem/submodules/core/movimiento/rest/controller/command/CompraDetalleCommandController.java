package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import com.saludsystem.submodules.movimiento.command.create.CompraDetalleCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.CompraDetalleDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.CompraDetalleEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraDetalleEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "ComprasDetalles")
@RestController
@RequestMapping("/api/ComprasDetalles")
public class CompraDetalleCommandController {

    private final CompraDetalleCreateHandler createHandler;
    private final CompraDetalleEditHandler editHandler;
    private final CompraDetalleDeleteHandler deleteHandler;

    public CompraDetalleCommandController(CompraDetalleCreateHandler createHandler, CompraDetalleEditHandler editHandler, CompraDetalleDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CompraDetalleCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, CompraDetalleConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID uuid, @RequestBody CompraDetalleEditCommand editCommand) {
        editHandler.execute(uuid, editCommand);
        return new ApiResponse(true, CompraDetalleConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID uuid) {
        deleteHandler.execute(uuid);
        return new ApiResponse(true, CompraDetalleConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import com.saludsystem.submodules.movimiento.command.create.VentaCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.VentaDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.VentaEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.VentaConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.VentaCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.VentaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Ventas")
@RestController
@RequestMapping("/api/Ventas")
public class VentaCommandController {

    private final VentaCreateHandler createHandler;
    private final VentaEditHandler editHandler;
    private final VentaDeleteHandler deleteHandler;

    public VentaCommandController(VentaCreateHandler createHandler, VentaEditHandler editHandler, VentaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody VentaCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, VentaConstant.CREATED);
    }

    @PutMapping("/Update/{ventaId}")
    public ApiResponse update(@PathVariable UUID ventaId, @RequestBody VentaEditCommand editCommand) {
        editHandler.execute(ventaId, editCommand);
        return new ApiResponse(true, VentaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{ventaId}")
    public ApiResponse delete(@PathVariable UUID ventaId) {
        deleteHandler.execute(ventaId);
        return new ApiResponse(true, VentaConstant.DELETED);
    }

}
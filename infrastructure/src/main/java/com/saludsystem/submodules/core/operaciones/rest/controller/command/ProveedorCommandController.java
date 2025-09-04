package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.ProveedorCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.ProveedorDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.ProveedorEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.ProveedorConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.ProveedorCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.ProveedorEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Proveedor")
@RestController
@RequestMapping("/api/Proveedor")
public class ProveedorCommandController {

    private final ProveedorCreateHandler createHandler;
    private final ProveedorEditHandler editHandler;
    private final ProveedorDeleteHandler deleteHandler;

    public ProveedorCommandController(ProveedorCreateHandler createHandler, ProveedorEditHandler editHandler, ProveedorDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody ProveedorCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, ProveedorConstant.CREATED);
    }

    @PutMapping("/Update/{proveedorId}")
    public ApiResponse update(@PathVariable UUID proveedorId, @RequestBody ProveedorEditCommand editCommand) {
        editHandler.execute(proveedorId, editCommand);
        return new ApiResponse(true, ProveedorConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{proveedorId}")
    public ApiResponse delete(@PathVariable UUID proveedorId) {
        deleteHandler.execute(proveedorId);
        return new ApiResponse(true, ProveedorConstant.DELETED);
    }

}
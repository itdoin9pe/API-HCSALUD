package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import com.saludsystem.submodules.configuracion.command.create.PermisoCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.PermisoDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.PermisoEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.PermisoConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.PermisoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.edit.PermisoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Permisos")
@RestController
@RequestMapping("/api/Permisos")
public class PermisoCommandController {

    private final PermisoCreateHandler createHandler;
    private final PermisoEditHandler editHandler;
    private final PermisoDeleteHandler deleteHandler;

    public PermisoCommandController(PermisoCreateHandler createHandler, PermisoEditHandler editHandler, PermisoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody PermisoCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, PermisoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody PermisoEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, PermisoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, PermisoConstant.DELETED);
    }

}
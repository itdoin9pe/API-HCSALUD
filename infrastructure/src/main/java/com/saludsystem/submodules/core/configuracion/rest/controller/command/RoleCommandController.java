package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import com.saludsystem.submodules.configuracion.command.create.RolCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.RolDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.RolEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.RolConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.RolCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.RolEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/Roles")
public class RoleCommandController {

    private final RolCreateHandler createHandler;
    private final RolEditHandler editHandler;
    private final RolDeleteHandler deleteHandler;

    public RoleCommandController(RolCreateHandler createHandler, RolEditHandler editHandler, RolDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping( "/Save")
    public ApiResponse save(@RequestBody RolCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, RolConstant.CREATED);
    }

    @PutMapping("/Update/{Id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody RolEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, RolConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable UUID doctorId) {
        deleteHandler.execute(doctorId);
        return new ApiResponse(true, RolConstant.DELETED);
    }

}
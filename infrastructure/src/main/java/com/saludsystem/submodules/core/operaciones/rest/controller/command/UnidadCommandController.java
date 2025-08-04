package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.UnidadCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.UnidadDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.UnidadEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.UnidadConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.UnidadCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.UnidadEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadCommandController {

    private final UnidadCreateHandler createHandler;
    private final UnidadEditHandler editHandler;
    private final UnidadDeleteHandler deleteHandler;

    public UnidadCommandController(UnidadCreateHandler createHandler, UnidadEditHandler editHandler, UnidadDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody UnidadCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, UnidadConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody UnidadEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, UnidadConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, UnidadConstant.DELETED);
    }

}
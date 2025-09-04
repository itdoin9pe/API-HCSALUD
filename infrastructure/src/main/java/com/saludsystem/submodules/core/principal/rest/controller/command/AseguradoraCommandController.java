package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.principal.command.create.AseguradoraCreateHandler;
import com.saludsystem.submodules.principal.command.delete.AseguradoraDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.AseguradoraEditHandler;
import com.saludsystem.submodules.principal.model.constant.AseguradoraConstant;
import com.saludsystem.submodules.principal.model.dtos.command.AseguradoraCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.AseguradoraEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraCommandController {

    private final AseguradoraCreateHandler createHandler;
    private final AseguradoraEditHandler editHandler;
    private final AseguradoraDeleteHandler deleteHandler;

    public AseguradoraCommandController(AseguradoraCreateHandler createHandler, AseguradoraEditHandler editHandler, AseguradoraDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody AseguradoraCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, AseguradoraConstant.CREATED);
    }

    @PutMapping("/Update/{aseguradoraId}")
    public ApiResponse update(@PathVariable UUID aseguradoraId, @RequestBody AseguradoraEditCommand dto) {
        editHandler.execute(aseguradoraId, dto);
        return new ApiResponse(true, AseguradoraConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{aseguradoraId}")
    public ApiResponse delete(@PathVariable UUID aseguradoraId) {
        deleteHandler.execute(aseguradoraId);
        return new ApiResponse(true, AseguradoraConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.principal.command.create.AseguradoraCreateHandler;
import com.saludsystem.submodules.principal.command.delete.AseguradoraDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.AseguradoraEditHandler;
import com.saludsystem.submodules.principal.model.constant.AseguradoraConstant;
import com.saludsystem.submodules.principal.model.dtos.post.CrearAseguradoraDTO;
import com.saludsystem.submodules.principal.model.dtos.put.ActualizarAseguradoraDTO;
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
    public ApiResponse save(@RequestBody CrearAseguradoraDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, AseguradoraConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarAseguradoraDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, AseguradoraConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, AseguradoraConstant.DELETED);
    }

}
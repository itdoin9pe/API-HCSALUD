package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.ApoderadoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ApoderadoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ApoderadoEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.ApoderadoConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ApoderadoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Apoderados")
@RestController
@RequestMapping("/api/Apoderados")
public class ApoderadoCommandController {

    private final ApoderadoCreateHandler createHandler;
    private final ApoderadoEditHandler editHandler;
    private final ApoderadoDeleteHandler deleteHandler;

    public ApoderadoCommandController(ApoderadoCreateHandler createHandler, ApoderadoEditHandler editHandler, ApoderadoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody ApoderadoCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, ApoderadoConstant.CREATED);
    }

    @PutMapping("/Update/{apoderadoId}")
    public ApiResponse update(@PathVariable UUID apoderadoId, @RequestBody ApoderadoEditCommand dto) {
        editHandler.execute(apoderadoId, dto);
        return new ApiResponse(true, ApoderadoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{apoderadoId}")
    public ApiResponse delete(@PathVariable UUID apoderadoId) {
        deleteHandler.execute(apoderadoId);
        return new ApiResponse(true, ApoderadoConstant.DELETED);
    }
    
}
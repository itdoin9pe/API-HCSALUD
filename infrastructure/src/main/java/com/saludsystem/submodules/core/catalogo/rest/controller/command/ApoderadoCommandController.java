package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.ApoderadoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ApoderadoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ApoderadoEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.ApoderadoConstant;
import com.saludsystem.submodules.catalogo.dto.command.CrearApoderadoDTO;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarApoderadoDTO;
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
    public ApiResponse save(@RequestBody CrearApoderadoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, ApoderadoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarApoderadoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, ApoderadoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, ApoderadoConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.EspecialidadCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.EspecialidadDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.EspecialidadEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.EspecialidadConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarEspecialidadDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadCommandController {

    private final EspecialidadCreateHandler createHandler;
    private final EspecialidadEditHandler editHandler;
    private final EspecialidadDeleteHandler deleteHandler;

    public EspecialidadCommandController(EspecialidadCreateHandler createHandler, EspecialidadEditHandler editHandler, EspecialidadDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearEspecialidadDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, EspecialidadConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarEspecialidadDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, EspecialidadConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, EspecialidadConstant.DELETED);
    }
}
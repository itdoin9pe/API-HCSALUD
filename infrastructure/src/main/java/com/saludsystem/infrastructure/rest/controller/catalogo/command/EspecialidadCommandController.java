package com.saludsystem.infrastructure.rest.controller.catalogo.command;

import com.saludsystem.application.catalogo.command.create.EspecialidadCreateHandler;
import com.saludsystem.application.catalogo.command.delete.EspecialidadDeleteHandler;
import com.saludsystem.application.catalogo.command.edit.EspecialidadEditHandler;
import com.saludsystem.application.catalogo.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarEspecialidadDTO;
import com.saludsystem.domain.response.ApiResponse;
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
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarEspecialidadDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }
}
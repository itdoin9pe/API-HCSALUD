package com.saludsystem.infrastructure.rest.controller.catalogo.command;

import com.saludsystem.application.catalogo.command.create.ApoderadoCreateHandler;
import com.saludsystem.application.catalogo.command.delete.ApoderadoDeleteHandler;
import com.saludsystem.application.catalogo.command.edit.ApoderadoEditHandler;
import com.saludsystem.application.catalogo.dtos.post.CrearApoderadoDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.domain.response.ApiResponse;
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
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarApoderadoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }

}
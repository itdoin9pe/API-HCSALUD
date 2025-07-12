package com.saludsystem.infrastructure.rest.controller.catalogo.command;

import com.saludsystem.application.catalogo.command.create.ConsentimientoCreateHandler;
import com.saludsystem.application.catalogo.command.delete.ConsentimientoDeleteHandler;
import com.saludsystem.application.catalogo.command.edit.ConsentimientoEditHandler;
import com.saludsystem.application.catalogo.dtos.post.CrearConsentimientoDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarConsentimientoDTO;
import com.saludsystem.domain.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoCommandController {

    private final ConsentimientoCreateHandler createHandler;
    private final ConsentimientoEditHandler editHandler;
    private final ConsentimientoDeleteHandler deleteHandler;

    public ConsentimientoCommandController(ConsentimientoCreateHandler createHandler, ConsentimientoEditHandler editHandler, ConsentimientoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearConsentimientoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarConsentimientoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }
}
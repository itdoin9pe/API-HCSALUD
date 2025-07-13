package com.saludsystem.infrastructure.rest.controller.catalogo.command;

import com.saludsystem.application.catalogo.command.create.TipoConceptoCreateHandler;
import com.saludsystem.application.catalogo.command.delete.TipoConceptoDeleteHandler;
import com.saludsystem.application.catalogo.command.edit.TipoConceptoEditHandler;
import com.saludsystem.application.catalogo.dtos.post.CrearTipoConceptoDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarTipoConceptoDTO;
import com.saludsystem.domain.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoCommandController {

    private final TipoConceptoCreateHandler createHandler;
    private final TipoConceptoEditHandler editHandler;
    private final TipoConceptoDeleteHandler deleteHandler;

    public TipoConceptoCommandController(TipoConceptoCreateHandler createHandler, TipoConceptoEditHandler editHandler, TipoConceptoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }


    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearTipoConceptoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarTipoConceptoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }

}
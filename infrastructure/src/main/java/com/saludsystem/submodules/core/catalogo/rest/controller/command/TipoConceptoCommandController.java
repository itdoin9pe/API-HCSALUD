package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.TipoConceptoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.TipoConceptoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.TipoConceptoEditHandler;
import com.saludsystem.submodules.catalogo.model.dto.command.TipoConceptoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoConceptoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
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
    public ApiResponse save(@RequestBody TipoConceptoCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{tipoConceptoId}")
    public ApiResponse update(@PathVariable UUID tipoConceptoId, @RequestBody TipoConceptoEditCommand dto) {
        editHandler.execute(tipoConceptoId, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{tipoConcenptoId}")
    public ApiResponse delete(@PathVariable UUID tipoConceptoId) {
        deleteHandler.execute(tipoConceptoId);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }

}
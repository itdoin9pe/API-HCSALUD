package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.TipoConceptoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.TipoConceptoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.TipoConceptoEditHandler;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarTipoConceptoDTO;
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
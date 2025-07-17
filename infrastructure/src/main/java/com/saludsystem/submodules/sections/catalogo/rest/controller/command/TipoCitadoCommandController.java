package com.saludsystem.submodules.sections.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.TipoCitadoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.TipoCitadoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.TipoCitadoEditHandler;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarTipoCitadoDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposCitado")
@RestController
@RequestMapping("/api/TiposCitado")
public class TipoCitadoCommandController {

    private final TipoCitadoCreateHandler createHandler;
    private final TipoCitadoEditHandler editHandler;
    private final TipoCitadoDeleteHandler deleteHandler;

    public TipoCitadoCommandController(TipoCitadoCreateHandler createHandler, TipoCitadoEditHandler editHandler, TipoCitadoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearTipoCitadoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarTipoCitadoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }

}
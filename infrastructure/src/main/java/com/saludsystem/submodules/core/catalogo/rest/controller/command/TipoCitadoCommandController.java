package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.TipoCitadoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.TipoCitadoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.TipoCitadoEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.TipoCitadoConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.TipoCitadoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoCitadoEditCommand;
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
    public ApiResponse save(@RequestBody TipoCitadoCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TipoCitadoConstant.CREATED);
    }

    @PutMapping("/Update/{tipoCitadoId}")
    public ApiResponse update(@PathVariable UUID tipoCitadoId, @RequestBody TipoCitadoEditCommand dto) {
        editHandler.execute(tipoCitadoId, dto);
        return new ApiResponse(true, TipoCitadoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{tipoCitadoId}")
    public ApiResponse delete(@PathVariable UUID tipoCitadoId) {
        deleteHandler.execute(tipoCitadoId);
        return new ApiResponse(true, TipoCitadoConstant.DELETED);
    }

}
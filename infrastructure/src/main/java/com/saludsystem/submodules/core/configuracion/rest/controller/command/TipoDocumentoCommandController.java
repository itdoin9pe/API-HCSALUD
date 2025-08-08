package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import com.saludsystem.submodules.configuracion.command.create.TipoDocumentoCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.TipoDocumentoDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.TipoDocumentoEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.TipoDocumentoConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.TipoDocumentoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.TipoDocumentoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoCommandController {

    private final TipoDocumentoCreateHandler createHandler;
    private final TipoDocumentoEditHandler editHandler;
    private final TipoDocumentoDeleteHandler deleteHandler;

    public TipoDocumentoCommandController(TipoDocumentoCreateHandler createHandler, TipoDocumentoEditHandler editHandler, TipoDocumentoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody TipoDocumentoCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, TipoDocumentoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody TipoDocumentoEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, TipoDocumentoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, TipoDocumentoConstant.DELETED);
    }

}
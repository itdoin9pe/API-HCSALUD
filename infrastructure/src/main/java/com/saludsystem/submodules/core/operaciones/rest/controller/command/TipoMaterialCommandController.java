package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.TipoMaterialCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.TipoMaterialDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.TipoMaterialEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.TipoMaterialConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.TipoMaterialCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.TipoMaterialEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMateriales")
@RestController
@RequestMapping("/api/TiposMateriales")
public class TipoMaterialCommandController {

    private final TipoMaterialCreateHandler createHandler;
    private final TipoMaterialEditHandler editHandler;
    private final TipoMaterialDeleteHandler deleteHandler;

    public TipoMaterialCommandController(TipoMaterialCreateHandler createHandler, TipoMaterialEditHandler editHandler, TipoMaterialDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody TipoMaterialCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, TipoMaterialConstant.CREATED);
    }

    @PutMapping("/Update/{tipoMaterialId}")
    public ApiResponse update(@PathVariable UUID tipoMaterialId, @RequestBody TipoMaterialEditCommand editCommand) {
        editHandler.execute(tipoMaterialId, editCommand);
        return new ApiResponse(true, TipoMaterialConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{tipoMaterialId}")
    public ApiResponse delete(@PathVariable UUID tipoMaterialId) {
        deleteHandler.execute(tipoMaterialId);
        return new ApiResponse(true, TipoMaterialConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.TipoGastoCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TipoGastoDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TipoGastoEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoGastoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoGastoDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "ConceptosGastos")
@RestController
@RequestMapping("/api/ConceptosGastos")
public class TipoGastoCommandController {

    private final TipoGastoCreateHandler createHandler;
    private final TipoGastoEditHandler editHandler;
    private final TipoGastoDeleteHandler deleteHandler;

    public TipoGastoCommandController(TipoGastoCreateHandler createHandler, TipoGastoEditHandler editHandler, TipoGastoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearTipoGastoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TipoGastoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarTipoGastoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, TipoGastoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, TipoGastoConstant.DELETED);
    }

}
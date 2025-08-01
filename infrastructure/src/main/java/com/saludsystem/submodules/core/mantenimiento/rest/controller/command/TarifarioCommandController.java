package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.TarifarioCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TarifarioDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TarifarioEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.TarifarioConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TarifarioCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TarifarioEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Tarifarios")
@RestController
@RequestMapping("/api/Tarifarios")
public class TarifarioCommandController {

    private final TarifarioCreateHandler createHandler;
    private final TarifarioEditHandler editHandler;
    private final TarifarioDeleteHandler deleteHandler;

    public TarifarioCommandController(TarifarioCreateHandler createHandler, TarifarioEditHandler editHandler, TarifarioDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody TarifarioCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TarifarioConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody TarifarioEditCommand dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, TarifarioConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, TarifarioConstant.DELETED);
    }
}
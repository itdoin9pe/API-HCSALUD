package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.mantenimiento.command.create.MonedaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.MonedaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.MonedaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.MonedaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.MonedadEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaCommandController {

    private final MonedaCreateHandler createHandler;
    private final MonedaEditHandler editHandler;
    private final MonedaDeleteHandler deleteHandler;

    public MonedaCommandController(MonedaCreateHandler createHandler, MonedaEditHandler editHandler, MonedaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody MonedaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, AlergiaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody MonedadEditCommand dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, AlergiaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, AlergiaConstant.DELETED);
    }

}
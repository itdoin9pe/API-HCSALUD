package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.CuentaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.CuentaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.CuentaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.CuentaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCuentaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarCuentaDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaCommandController {

    private final CuentaCreateHandler createHandler;
    private final CuentaEditHandler editHandler;
    private final CuentaDeleteHandler deleteHandler;

    public CuentaCommandController(CuentaCreateHandler createHandler, CuentaEditHandler editHandler, CuentaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearCuentaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, CuentaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarCuentaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, CuentaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, CuentaConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.CajaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.CajaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.CajaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.CajaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCajaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarCajaDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Cajas")
@RestController
@RequestMapping("/api/Cajas")
public class CajaCommandController {

    private final CajaCreateHandler createHandler;
    private final CajaEditHandler editHandler;
    private final CajaDeleteHandler deleteHandler;

    public CajaCommandController(CajaCreateHandler createHandler, CajaEditHandler editHandler, CajaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearCajaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, CajaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarCajaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, CajaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, CajaConstant.DELETED);
    }

}
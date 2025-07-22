package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.BancoCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.BancoDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.BancoEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.BancoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearBancoDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarBancoDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Bancos")
@RestController
@RequestMapping("/api/Bancos")
public class BancoCommandController {

    private final BancoCreateHandler createHandler;
    private final BancoEditHandler editHandler;
    private final BancoDeleteHandler deleteHandler;

    public BancoCommandController(BancoCreateHandler createHandler, BancoEditHandler editHandler, BancoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearBancoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, BancoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarBancoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, BancoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, BancoConstant.DELETED);
    }

}
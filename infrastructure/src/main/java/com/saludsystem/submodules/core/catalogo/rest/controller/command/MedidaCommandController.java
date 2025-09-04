package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.MedidaCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.MedidaDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.MedidaEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.MedidaConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.MedidaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.MedidaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Medidas")
@RestController
@RequestMapping("/api/Medidas")
public class MedidaCommandController {

    private final MedidaCreateHandler createHandler;
    private final MedidaEditHandler editHandler;
    private final MedidaDeleteHandler deleteHandler;

    public MedidaCommandController(MedidaCreateHandler createHandler, MedidaEditHandler editHandler, MedidaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody MedidaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, MedidaConstant.CREATED);
    }

    @PutMapping("/Update/{medidaId}")
    public ApiResponse update(@PathVariable UUID medidaId, @RequestBody MedidaEditCommand dto) {
        editHandler.execute(medidaId, dto);
        return new ApiResponse(true, MedidaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{medidaId}")
    public ApiResponse delete(@PathVariable UUID medidaId) {
        deleteHandler.execute(medidaId);
        return new ApiResponse(true, MedidaConstant.DELETED);
    }
}
package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.principal.command.create.EmpresaCreateHandler;
import com.saludsystem.submodules.principal.command.delete.EmpresaDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.EmpresaEditHandler;
import com.saludsystem.submodules.principal.model.dtos.command.EmpresaCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.EmpresaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaCommandController {

    private final EmpresaCreateHandler createHandler;
    private final EmpresaEditHandler editHandler;
    private final EmpresaDeleteHandler deleteHandler;

    public EmpresaCommandController(EmpresaCreateHandler createHandler, EmpresaEditHandler editHandler, EmpresaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody EmpresaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, AlergiaConstant.CREATED);
    }

    @PutMapping("/Update/{empresaId}")
    public ApiResponse update(@PathVariable UUID empresaId, @RequestBody EmpresaEditCommand dto) {
        editHandler.execute(empresaId, dto);
        return new ApiResponse(true, AlergiaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{empresaId}")
    public ApiResponse delete(@PathVariable UUID empresaId) {
        deleteHandler.execute(empresaId);
        return new ApiResponse(true, AlergiaConstant.DELETED);
    }

}
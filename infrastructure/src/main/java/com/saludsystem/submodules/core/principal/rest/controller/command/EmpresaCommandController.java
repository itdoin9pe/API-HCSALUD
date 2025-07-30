package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.principal.command.create.EmpresaCreateHandler;
import com.saludsystem.submodules.principal.command.delete.EmpresaDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.EmpresaEditHandler;
import com.saludsystem.submodules.principal.dtos.post.CrearEmpresaDTO;
import com.saludsystem.submodules.principal.dtos.put.ActualizarEmpresaDTO;
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
    public ApiResponse save(@RequestBody CrearEmpresaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, AlergiaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarEmpresaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, AlergiaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, AlergiaConstant.DELETED);
    }

}
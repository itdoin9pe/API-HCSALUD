package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.CategoriaMaterialCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.CategoriaMaterialDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.CategoriaMaterialEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.CategoriaMaterialConstant;
import com.saludsystem.submodules.operaciones.model.dtos.post.CrearCategotiaMatDTO;
import com.saludsystem.submodules.operaciones.model.dtos.put.ActualizarCategoriaMatDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatController{

    private final CategoriaMaterialCreateHandler createHandler;
    private final CategoriaMaterialEditHandler editHandler;
    private final CategoriaMaterialDeleteHandler deleteHandler;

    public CategoriaMatController(CategoriaMaterialCreateHandler createHandler, CategoriaMaterialEditHandler editHandler, CategoriaMaterialDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearCategotiaMatDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, CategoriaMaterialConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarCategoriaMatDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, CategoriaMaterialConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, CategoriaMaterialConstant.DELETED);
    }

}
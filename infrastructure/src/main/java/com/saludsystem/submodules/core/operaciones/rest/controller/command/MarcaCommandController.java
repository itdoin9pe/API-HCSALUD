package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.MarcaCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.MarcaDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.MarcaEditHandler;
import com.saludsystem.submodules.operaciones.constant.MarcaConstant;
import com.saludsystem.submodules.operaciones.dtos.command.CrearMarcaDTO;
import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarMarcaDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "MarcasMateriales")
@RestController
@RequestMapping("/api/MarcasMateriales")
public class MarcaCommandController {

    private final MarcaCreateHandler createHandler;
    private final MarcaEditHandler editHandler;
    private final MarcaDeleteHandler deleteHandler;

    public MarcaCommandController(MarcaCreateHandler createHandler, MarcaEditHandler editHandler, MarcaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearMarcaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, MarcaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarMarcaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, MarcaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, MarcaConstant.DELETED);
    }

}
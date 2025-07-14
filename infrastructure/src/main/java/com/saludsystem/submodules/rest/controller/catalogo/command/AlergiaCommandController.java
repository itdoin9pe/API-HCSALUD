package com.saludsystem.submodules.rest.controller.catalogo.command;

import com.saludsystem.submodules.catalogo.command.create.AlergiaCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.AlergiaDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.AlergiaEditHandler;
import com.saludsystem.submodules.catalogo.dtos.post.CrearAlergiaDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarAlergiaDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Alergias")
@RestController
@RequestMapping("/api/Alergias")
public class AlergiaCommandController {

    private final AlergiaCreateHandler createHandler;
    private final AlergiaEditHandler editHandler;
    private final AlergiaDeleteHandler deleteHandler;

    public AlergiaCommandController(AlergiaCreateHandler createHandler, AlergiaEditHandler editHandler, AlergiaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearAlergiaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro creado exitosamente");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarAlergiaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }
}
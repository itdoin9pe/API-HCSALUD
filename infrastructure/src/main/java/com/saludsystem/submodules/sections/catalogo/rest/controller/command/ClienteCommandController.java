package com.saludsystem.submodules.sections.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.ClienteCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ClienteDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ClienteEditHandler;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearClienteDTO;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarClienteDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Clientes")
@RestController
@RequestMapping("/api/Clientes")
public class ClienteCommandController {

    private final ClienteCreateHandler createHandler;
    private final ClienteEditHandler editHandler;
    private final ClienteDeleteHandler deleteHandler;

    public ClienteCommandController(ClienteCreateHandler createHandler, ClienteEditHandler editHandler, ClienteDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearClienteDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarClienteDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }
}
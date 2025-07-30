package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.ClienteCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ClienteDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ClienteEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.ClienteConstant;
import com.saludsystem.submodules.catalogo.dto.command.CrearClienteDTO;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarClienteDTO;
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
        return new ApiResponse(true, ClienteConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarClienteDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, ClienteConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, ClienteConstant.DELETED);
    }
}
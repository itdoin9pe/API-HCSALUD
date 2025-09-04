package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.ClienteCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ClienteDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ClienteEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.ClienteConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ClienteEditCommand;
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
    public ApiResponse save(@RequestBody ClienteCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, ClienteConstant.CREATED);
    }

    @PutMapping("/Update/{clienteId}")
    public ApiResponse update(@PathVariable UUID clienteId, @RequestBody ClienteEditCommand dto) {
        editHandler.execute(clienteId, dto);
        return new ApiResponse(true, ClienteConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{clienteId}")
    public ApiResponse delete(@PathVariable UUID clienteId) {
        deleteHandler.execute(clienteId);
        return new ApiResponse(true, ClienteConstant.DELETED);
    }
}
package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import com.saludsystem.submodules.movimiento.command.create.CompraCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.CompraDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.CompraEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.CompraConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Compras")
@RestController
@RequestMapping("/api/Compras")
public class CompraCommandController {

    private final CompraCreateHandler createHandler;
    private final CompraEditHandler editHandler;
    private final CompraDeleteHandler deleteHandler;

    public CompraCommandController(CompraCreateHandler createHandler, CompraEditHandler editHandler, CompraDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CompraCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, CompraConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody CompraEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, CompraConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, CompraConstant.DELETED);
    }

}
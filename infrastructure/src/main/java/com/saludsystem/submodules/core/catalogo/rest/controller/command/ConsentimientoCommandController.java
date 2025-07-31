package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.ConsentimientoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ConsentimientoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ConsentimientoEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.ConsentimientoConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ConsentimientoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoCommandController {

    private final ConsentimientoCreateHandler createHandler;
    private final ConsentimientoEditHandler editHandler;
    private final ConsentimientoDeleteHandler deleteHandler;

    public ConsentimientoCommandController(ConsentimientoCreateHandler createHandler, ConsentimientoEditHandler editHandler, ConsentimientoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody ConsentimientoCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, ConsentimientoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ConsentimientoEditCommand dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, ConsentimientoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, ConsentimientoConstant.DELETED);
    }
}
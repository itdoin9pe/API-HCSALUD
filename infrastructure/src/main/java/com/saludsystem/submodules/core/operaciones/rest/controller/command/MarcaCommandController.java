package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.MarcaCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.MarcaDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.MarcaEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.MarcaConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.MarcaCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.MarcaEditCommand;
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
    public ApiResponse save(@RequestBody MarcaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, MarcaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody MarcaEditCommand dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, MarcaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, MarcaConstant.DELETED);
    }

}
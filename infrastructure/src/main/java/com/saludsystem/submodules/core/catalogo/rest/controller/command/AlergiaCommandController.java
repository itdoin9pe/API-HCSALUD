package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.AlergiaCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.AlergiaDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.AlergiaEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.AlergiaEditCommand;
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
    public ApiResponse save(@RequestBody AlergiaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, AlergiaConstant.CREATED);
    }

    @PutMapping("/Update/{alergiaId}")
    public ApiResponse update(@PathVariable UUID alergiaId, @RequestBody AlergiaEditCommand dto) {
        editHandler.execute(alergiaId, dto);
        return new ApiResponse(true, AlergiaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{alergiaId}")
    public ApiResponse delete(@PathVariable UUID alergiaId) {
        deleteHandler.execute(alergiaId);
        return new ApiResponse(true, AlergiaConstant.DELETED);
    }

}
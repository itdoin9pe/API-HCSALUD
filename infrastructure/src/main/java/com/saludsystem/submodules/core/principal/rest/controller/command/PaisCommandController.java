package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.principal.command.create.PaisCreateHandler;
import com.saludsystem.submodules.principal.command.delete.PaisDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.PaisEditHandler;
import com.saludsystem.submodules.principal.model.constant.PaisConstant;
import com.saludsystem.submodules.principal.model.dtos.command.PaisCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.PaisEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisCommandController {

    private final PaisCreateHandler createHandler;
    private final PaisEditHandler editHandler;
    private final PaisDeleteHandler deleteHandler;

    public PaisCommandController(PaisCreateHandler createHandler, PaisEditHandler editHandler, PaisDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/SavePais")
    public ApiResponse store(@Valid @RequestBody PaisCreateCommand paisCreateCommand) {
        createHandler.execute(paisCreateCommand);
        return new ApiResponse(true, PaisConstant.CREATED);
    }

    @PutMapping("/Update/{paisId}")
    public ApiResponse update(@PathVariable Integer paisId, @RequestBody PaisEditCommand dto) {
        editHandler.execute(paisId, dto);
        return new ApiResponse(true, AlergiaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{paisId}")
    public ApiResponse delete(@PathVariable Integer paisId) {
        deleteHandler.execute(paisId);
        return new ApiResponse(true, AlergiaConstant.DELETED);
    }

}
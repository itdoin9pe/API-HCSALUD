package com.saludsystem.submodules.core.paciente.rest.controller.command;

import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.AlergiaEditCommand;
import com.saludsystem.submodules.paciente.command.create.EstudioMedicoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.EstudioMedicoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.EstudioMedicoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.EstudioMedicoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.EstudioMedicoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.EstudioMedicoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstudiosMedicos")
@RestController
@RequestMapping("/api/PacientesEstudiosMedicos")
public class EstudioMedicoCommandController {

    private final EstudioMedicoCreateHandler createHandler;
    private final EstudioMedicoEditHandler editHandler;
    private final EstudioMedicoDeleteHandler deleteHandler;

    public EstudioMedicoCommandController(EstudioMedicoCreateHandler createHandler, EstudioMedicoEditHandler editHandler, EstudioMedicoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody EstudioMedicoCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, EstudioMedicoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable Long id, @RequestBody EstudioMedicoEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, EstudioMedicoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, EstudioMedicoConstant.DELETED);
    }

}
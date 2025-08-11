package com.saludsystem.submodules.core.paciente.rest.controller.command.historialclinico;

import com.saludsystem.submodules.paciente.command.create.historialclinico.ExploracionFisicaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.historialclinico.ExploracionFisicaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.historialclinico.ExploracionFisicaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ExploracionConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.ExploracionFisicaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.ExploracionFisicaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesExploraciones")
@RestController
@RequestMapping("/api/Pacientes/Exploraciones")
public class ExploracionFisicaCommandController {

    private final ExploracionFisicaCreateHandler createHandler;
    private final ExploracionFisicaEditHandler editHandler;
    private final ExploracionFisicaDeleteHandler deleteHandler;

    public ExploracionFisicaCommandController(ExploracionFisicaCreateHandler createHandler, ExploracionFisicaEditHandler editHandler, ExploracionFisicaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody ExploracionFisicaCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, ExploracionConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ExploracionFisicaEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, ExploracionConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, ExploracionConstant.DELETED);
    }

}
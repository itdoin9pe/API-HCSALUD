package com.saludsystem.submodules.core.paciente.rest.controller.command;

import com.saludsystem.submodules.paciente.command.create.EstudioResultadoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.EstudioResultadoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.EstudioResultadoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.EstudioResultadoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.EstudioResultadoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.EstudioResultadoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesEstudiosResultados")
@RestController
@RequestMapping("/api/PacientesEstudiosResultados")
public class EstudioResultadoCommandController {

    private final EstudioResultadoCreateHandler createHandler;
    private final EstudioResultadoEditHandler editHandler;
    private final EstudioResultadoDeleteHandler deleteHandler;

    public EstudioResultadoCommandController(EstudioResultadoCreateHandler createHandler, EstudioResultadoEditHandler editHandler, EstudioResultadoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody EstudioResultadoCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, EstudioResultadoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable Long id, @RequestBody EstudioResultadoEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, EstudioResultadoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, EstudioResultadoConstant.DELETED);
    }

}
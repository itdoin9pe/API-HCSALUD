package com.saludsystem.submodules.core.paciente.rest.controller.command.interconsulta;

import com.saludsystem.submodules.paciente.command.create.interconsulta.InterconsultaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.interconsulta.InterconsultaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.interconsulta.InterconsultaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InterconsultaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta.InterconsultaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta.InterconsultaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesInterconsultas")
@RestController
@RequestMapping("/api/PacientesInterconsultas")
public class InterconsultaCommandController {

    private final InterconsultaCreateHandler createHandler;
    private final InterconsultaEditHandler editHandler;
    private final InterconsultaDeleteHandler deleteHandler;

    public InterconsultaCommandController(InterconsultaCreateHandler createHandler, InterconsultaEditHandler editHandler, InterconsultaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody InterconsultaCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, InterconsultaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody InterconsultaEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, InterconsultaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, InterconsultaConstant.DELETED);
    }

}

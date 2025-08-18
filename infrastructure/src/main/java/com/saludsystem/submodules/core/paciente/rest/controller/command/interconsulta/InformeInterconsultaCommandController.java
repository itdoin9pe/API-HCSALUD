package com.saludsystem.submodules.core.paciente.rest.controller.command.interconsulta;

import com.saludsystem.submodules.paciente.command.create.interconsulta.InformeInterconsultaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.interconsulta.InformeInterconsultaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.interconsulta.InformeInterconsultaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InformeInterconsultaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta.InformeInterconsultaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta.InformeInterconsultaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesInformesInterconsultas")
@RestController
@RequestMapping("/api/PacientesInformesInterconsultas")
public class InformeInterconsultaCommandController {

    private final InformeInterconsultaCreateHandler createHandler;
    private final InformeInterconsultaEditHandler editHandler;
    private final InformeInterconsultaDeleteHandler deleteHandler;

    public InformeInterconsultaCommandController(InformeInterconsultaCreateHandler createHandler,
                                                 InformeInterconsultaEditHandler editHandler,
                                                 InformeInterconsultaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody InformeInterconsultaCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, InformeInterconsultaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody InformeInterconsultaEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, InformeInterconsultaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, InformeInterconsultaConstant.DELETED);
    }

}

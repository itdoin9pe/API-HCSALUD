package com.saludsystem.submodules.core.paciente.rest.controller.command;

import com.saludsystem.submodules.paciente.command.create.PacienteCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.PacienteDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.PacienteEditHandler;
import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.PacienteCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PacienteEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteCommandController {

    private final PacienteCreateHandler createHandler;
    private final PacienteEditHandler editHandler;
    private final PacienteDeleteHandler deleteHandler;

    public PacienteCommandController(PacienteCreateHandler createHandler, PacienteEditHandler editHandler, PacienteDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/Save")
    public ApiResponse save(@Valid @RequestBody PacienteCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, PacienteConstant.CREATED);
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/Update/{Id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse update(@PathVariable UUID id, @RequestBody PacienteEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, PacienteConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable UUID doctorId) {
        deleteHandler.execute(doctorId);
        return new ApiResponse(true, PacienteConstant.DELETED);
    }

}
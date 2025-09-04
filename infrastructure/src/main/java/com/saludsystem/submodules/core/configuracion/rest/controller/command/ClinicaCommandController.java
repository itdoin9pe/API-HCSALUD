package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import com.saludsystem.submodules.configuracion.command.create.ClinicaCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.ClinicaDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.ClinicaEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.ClinicaConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.ClinicaCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.ClinicaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Hospitales")
@RestController
@RequestMapping("/api/Hospitales")
public class ClinicaCommandController {

    private final ClinicaCreateHandler createHandler;
    private final ClinicaEditHandler editHandler;
    private final ClinicaDeleteHandler deleteHandler;

    public ClinicaCommandController(ClinicaCreateHandler createHandler, ClinicaEditHandler editHandler, ClinicaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse create(@Valid @RequestBody ClinicaCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, ClinicaConstant.CREATED);
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/Update/{hospitalId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse update(@PathVariable UUID hospitalId, @RequestBody ClinicaEditCommand editCommand) {
        editHandler.execute(hospitalId, editCommand);
        return new ApiResponse(true, ClinicaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{hospitalId}")
    public ApiResponse delete(@PathVariable UUID hospitalId) {
        deleteHandler.execute(hospitalId);
        return new ApiResponse(true, ClinicaConstant.DELETED);
    }

}
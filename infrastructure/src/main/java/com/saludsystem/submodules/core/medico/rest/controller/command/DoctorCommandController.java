package com.saludsystem.submodules.core.medico.rest.controller.command;

import com.saludsystem.submodules.medico.command.create.DoctorCreateHandler;
import com.saludsystem.submodules.medico.command.delete.DoctorDeleteHandler;
import com.saludsystem.submodules.medico.command.edit.DoctorEditHandler;
import com.saludsystem.submodules.medico.constant.DoctorConstant;
import com.saludsystem.submodules.medico.dtos.ActualizarDoctorDTO;
import com.saludsystem.submodules.medico.dtos.CrearDoctorDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Medicos")
@RestController
@RequestMapping("/api/Medicos")
public class DoctorCommandController {

    private final DoctorCreateHandler createHandler;
    private final DoctorEditHandler editHandler;
    private final DoctorDeleteHandler deleteHandler;

    public DoctorCommandController(DoctorCreateHandler createHandler, DoctorEditHandler editHandler, DoctorDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SaveDoctor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse save(@RequestBody CrearDoctorDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, DoctorConstant.CREATED);
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/UpdateDoctor/{doctorId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarDoctorDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, DoctorConstant.UPDATED);
    }

    @DeleteMapping("/DeleteDoctor/{doctorId}")
    public ApiResponse destroy(@PathVariable UUID doctorId) {
        deleteHandler.execute(doctorId);
        return new ApiResponse(true, DoctorConstant.DELETED);
    }

}
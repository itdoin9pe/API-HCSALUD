package com.saludsystem.submodules.core.cita.rest.controller.command;

import com.saludsystem.submodules.cita.command.CitaCreateHandler;
import com.saludsystem.submodules.cita.command.CitaDeleteHandler;
import com.saludsystem.submodules.cita.command.CitaEditHandler;
import com.saludsystem.submodules.cita.model.constant.CitaConstant;
import com.saludsystem.submodules.cita.model.dtos.command.CitaCreateCommand;
import com.saludsystem.submodules.cita.model.dtos.command.CitaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CitasMedicas")
@RestController
@RequestMapping("/api/CitasMedicas")
public class CitaCommandController {

    private final CitaCreateHandler createHandler;
    private final CitaEditHandler editHandler;
    private final CitaDeleteHandler deleteHandler;

    public CitaCommandController(CitaCreateHandler createHandler, CitaEditHandler editHandler, CitaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CitaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, CitaConstant.CREATED);
    }

    @PutMapping("/Update/{citaId}")
    public ApiResponse update(@PathVariable UUID citaId, @RequestBody CitaEditCommand dto) {
        editHandler.execute(citaId, dto);
        return new ApiResponse(true, CitaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{citaId}")
    public ApiResponse delete(@PathVariable UUID citaId) {
        deleteHandler.execute(citaId);
        return new ApiResponse(true, CitaConstant.DELETED);
    }

}
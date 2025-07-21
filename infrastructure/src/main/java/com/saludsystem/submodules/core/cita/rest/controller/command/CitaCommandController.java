package com.saludsystem.submodules.core.cita.rest.controller.command;

import com.saludsystem.submodules.cita.command.create.CitaCreateHandler;
import com.saludsystem.submodules.cita.command.delete.CitaDeleteHandler;
import com.saludsystem.submodules.cita.command.edit.CitaEditHandler;
import com.saludsystem.submodules.cita.model.constant.CitaConstant;
import com.saludsystem.submodules.cita.model.dtos.post.CrearCitaDTO;
import com.saludsystem.submodules.cita.model.dtos.put.ActualizarCitaDTO;
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
    public ApiResponse save(@RequestBody CrearCitaDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, CitaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarCitaDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, CitaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, CitaConstant.DELETED);
    }

}
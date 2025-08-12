package com.saludsystem.submodules.core.paciente.rest.controller.command.tratamiento;

import com.saludsystem.submodules.paciente.command.create.tratamiento.PlanTratamientoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.tratamiento.PlanTratamientoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.tratamiento.PlanTratamientoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.PlanTratamientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.PlanTratamientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.PlanTratamientoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/Pacientes/PlanesTratamientos")
public class PlanTratamientoCommandController {

    private final PlanTratamientoCreateHandler createHandler;
    private final PlanTratamientoEditHandler editHandler;
    private final PlanTratamientoDeleteHandler deleteHandler;

    public PlanTratamientoCommandController(PlanTratamientoCreateHandler createHandler, PlanTratamientoEditHandler editHandler, PlanTratamientoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody PlanTratamientoCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, PlanTratamientoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody PlanTratamientoEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, PlanTratamientoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, PlanTratamientoConstant.DELETED);
    }

}
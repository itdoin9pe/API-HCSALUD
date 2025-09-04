package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.EnfermedadCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.EnfermedadDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.EnfermedadEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.EnfermedadConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.EnfermedadCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.EnfermedadEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Enfermedades")
@RestController
@RequestMapping("/api/Enfermedades")
public class DiagnositcoCommandController {

    private final EnfermedadCreateHandler createHandler;
    private final EnfermedadEditHandler editHandler;
    private final EnfermedadDeleteHandler deleteHandler;

    public DiagnositcoCommandController(EnfermedadCreateHandler createHandler, EnfermedadEditHandler editHandler, EnfermedadDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/SaveEnfermedad")
    public ApiResponse stored(@Valid @RequestBody EnfermedadCreateCommand enfermedadCreateCommand) {
        createHandler.execute(enfermedadCreateCommand);
        return new ApiResponse(true, EnfermedadConstant.CREATED);
    }

    @PutMapping("/UpdateEnfermedad/{enfermedadId}")
    public ApiResponse update(@PathVariable String enfermedadId, @RequestBody EnfermedadEditCommand enfermedadEditCommand) {
        editHandler.execute(enfermedadId, enfermedadEditCommand);
        return new ApiResponse(true, EnfermedadConstant.UPDATED);
    }

    @DeleteMapping("/DeleteEnfermedad/{enfermedadId}")
    public ApiResponse destroy(@PathVariable String enfermedadId) {
        deleteHandler.execute(enfermedadId);
        return new ApiResponse(true, EnfermedadConstant.DELETED);
    }

    /*
    @GetMapping("/GetEnfermedadFiltradosPorRol")
    public ResponseEntity<List<EnfermedadDTO>> getEnfermedadFiltradosPorRol() {
        return ResponseEntity.ok(enfermedadService.getEnfermedadFiltradosPorRol());
    }*/

}
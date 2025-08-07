package com.saludsystem.submodules.core.paciente.rest.controller.command;

import com.saludsystem.submodules.paciente.command.create.MedicamentoRecetadoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.MedicamentoRecetadoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.MedicamentoRecetadoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.MedicamentoRecetadoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.MedicamentoRecetadoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/Pacientes/MedicamentosRecetados")
public class MedicamentoRecetadoCommandController {

    private final MedicamentoRecetadoCreateHandler createHandler;
    private final MedicamentoRecetadoEditHandler editHandler;
    private final MedicamentoRecetadoDeleteHandler deleteHandler;

    public MedicamentoRecetadoCommandController(MedicamentoRecetadoCreateHandler createHandler, MedicamentoRecetadoEditHandler editHandler, MedicamentoRecetadoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody MedicamentoRecetadoCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, MedicamentoRecetadoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody MedicamentoRecetadoEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, MedicamentoRecetadoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, MedicamentoRecetadoConstant.DELETED);
    }

}
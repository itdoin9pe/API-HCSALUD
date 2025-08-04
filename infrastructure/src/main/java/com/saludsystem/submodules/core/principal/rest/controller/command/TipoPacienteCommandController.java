package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.principal.command.create.TipoPacienteCreateHandler;
import com.saludsystem.submodules.principal.command.delete.TipoPacienteDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.TipoPacienteEditHandler;
import com.saludsystem.submodules.principal.model.constant.TipoPacienteConstant;
import com.saludsystem.submodules.principal.model.dtos.command.TipoPacienteCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.edit.TipoPacienteEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TiposPaciente")
@RestController
@RequestMapping("/api/TiposPaciente")
public class TipoPacienteCommandController {

    private final TipoPacienteCreateHandler createHandler;
    private final TipoPacienteEditHandler editHandler;
    private final TipoPacienteDeleteHandler deleteHandler;

    public TipoPacienteCommandController(TipoPacienteCreateHandler createHandler, TipoPacienteEditHandler editHandler, TipoPacienteDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody TipoPacienteCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TipoPacienteConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable Long id, @RequestBody TipoPacienteEditCommand dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, TipoPacienteConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, TipoPacienteConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.MedicamentoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.MedicamentoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.MedicamentoEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.MedicamentoConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.MedicamentoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Medicamentos")
@RestController
@RequestMapping("/api/Medicamentos")
public class MedicamentoCommandController {

    private final MedicamentoCreateHandler createHandler;
    private final MedicamentoEditHandler editHandler;
    private final MedicamentoDeleteHandler deleteHandler;

    public MedicamentoCommandController(MedicamentoCreateHandler createHandler, MedicamentoEditHandler editHandler, MedicamentoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody MedicamentoCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, MedicamentoConstant.CREATED);
    }

    @PutMapping("/Update/{medicamentoId}")
    public ApiResponse update(@PathVariable UUID medicamentoId, @RequestBody MedicamentoEditCommand dto) {
        editHandler.execute(medicamentoId, dto);
        return new ApiResponse(true, MedicamentoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{medicamentoId}")
    public ApiResponse delete(@PathVariable UUID medicamentoId) {
        deleteHandler.execute(medicamentoId);
        return new ApiResponse(true, MedicamentoConstant.DELETED);
    }
}
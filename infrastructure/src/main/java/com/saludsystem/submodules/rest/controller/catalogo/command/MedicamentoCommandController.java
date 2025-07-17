package com.saludsystem.submodules.rest.controller.catalogo.command;

import com.saludsystem.submodules.catalogo.command.create.MedicamentoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.MedicamentoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.MedicamentoEditHandler;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedicamentoDTO;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarMedicamentoDTO;
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
    public ApiResponse save(@RequestBody CrearMedicamentoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, "Registro agregado");
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarMedicamentoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }
}
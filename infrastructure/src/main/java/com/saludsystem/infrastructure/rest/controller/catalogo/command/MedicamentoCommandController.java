package com.saludsystem.infrastructure.rest.controller.catalogo.command;

import com.saludsystem.application.catalogo.command.create.MedicamentoCreateHandler;
import com.saludsystem.application.catalogo.command.delete.MedicamentoDeleteHandler;
import com.saludsystem.application.catalogo.command.edit.MedicamentoEditHandler;
import com.saludsystem.application.catalogo.dtos.post.CrearMedicamentoDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarMedicamentoDTO;
import com.saludsystem.domain.response.ApiResponse;
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
package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import com.saludsystem.submodules.mantenimiento.command.create.TipoPagoCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TipoPagoDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TipoPagoEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoPagoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoPagoDTO;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposPagos")
@RestController
@RequestMapping("/api/TiposPagos")
public class TipoPagoCommandController {

    private final TipoPagoCreateHandler createHandler;
    private final TipoPagoEditHandler editHandler;
    private final TipoPagoDeleteHandler deleteHandler;

    public TipoPagoCommandController(TipoPagoCreateHandler createHandler, TipoPagoEditHandler editHandler, TipoPagoDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody CrearTipoPagoDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, TipoPagoConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarTipoPagoDTO dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, TipoPagoConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, TipoPagoConstant.DELETED);
    }

}
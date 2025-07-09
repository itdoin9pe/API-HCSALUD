package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.get.CuentaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearCuentaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarCuentaDTO;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.CuentaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaController extends GenericController<CuentaDTO, CrearCuentaDTO, ActualizarCuentaDTO, UUID> {

    protected CuentaController(GenericService<CuentaDTO, CrearCuentaDTO, ActualizarCuentaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaListResponse.class)))
    })
    public ListResponse<CuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
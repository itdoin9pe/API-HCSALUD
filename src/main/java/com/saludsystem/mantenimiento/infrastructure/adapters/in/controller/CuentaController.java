package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.res.CuentaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearCuentaDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.CuentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaController extends GenericController<CrearCuentaDTO, CuentaDTO, UUID> {

    protected CuentaController(GenericService<CrearCuentaDTO, CuentaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaResponse.class)))
    })
    public ListResponse<CuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
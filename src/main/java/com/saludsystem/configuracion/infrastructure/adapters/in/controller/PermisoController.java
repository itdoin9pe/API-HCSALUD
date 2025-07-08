package com.saludsystem.configuracion.infrastructure.adapters.in.controller;

import com.saludsystem.configuracion.application.dto.res.PermisoResponse;
import com.saludsystem.configuracion.application.dto.req.PermisoRequest;
import com.saludsystem.configuracion.infrastructure.adapters.in.response.PermisoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Permisos")
@RestController
@RequestMapping("/api/Permisos")
public class PermisoController extends GenericController<PermisoRequest, PermisoResponse, UUID> {

    protected PermisoController(GenericService<PermisoRequest, PermisoResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermisoListResponse.class)))
    })
    public ListResponse<PermisoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
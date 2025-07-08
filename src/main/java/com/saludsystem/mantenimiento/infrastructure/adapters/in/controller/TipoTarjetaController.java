package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.res.TipoTarjetaResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoTarjetaRequest;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.TipoTarjetaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaController extends GenericController<TipoTarjetaRequest, TipoTarjetaResponse, UUID> {

    protected TipoTarjetaController(GenericService<TipoTarjetaRequest, TipoTarjetaResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoTarjetaListResponse.class)))
    })
    public ListResponse<TipoTarjetaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
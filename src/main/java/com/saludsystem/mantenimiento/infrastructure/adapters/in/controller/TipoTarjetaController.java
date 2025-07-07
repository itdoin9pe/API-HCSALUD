package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.res.TipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearTipoTarjetaDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.TipoTarjetaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaController extends GenericController<CrearTipoTarjetaDTO, TipoTarjetaDTO, UUID> {

    protected TipoTarjetaController(GenericService<CrearTipoTarjetaDTO, TipoTarjetaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoTarjetaResponse.class)))
    })
    public ListResponse<TipoTarjetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
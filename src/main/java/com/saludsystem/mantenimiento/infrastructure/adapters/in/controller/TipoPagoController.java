package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.res.TipoPagoDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearTipoPagoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.TipoPagoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposPagos")
@RestController
@RequestMapping("/api/TiposPagos")
public class TipoPagoController extends GenericController<CrearTipoPagoDTO, TipoPagoDTO, UUID> {

    protected TipoPagoController(GenericService<CrearTipoPagoDTO, TipoPagoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoPagoResponse.class)))
    })
    public ListResponse<TipoPagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
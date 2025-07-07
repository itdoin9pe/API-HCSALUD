package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.res.TipoConceptoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearTipoConceptoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.TipoConceptoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoController extends GenericController<CrearTipoConceptoDTO, TipoConceptoDTO, UUID> {

    protected TipoConceptoController(GenericService<CrearTipoConceptoDTO, TipoConceptoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoConceptoResponse.class)))
    })
    public ListResponse<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
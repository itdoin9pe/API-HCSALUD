package com.saludsystem.infrastructure.rest.controller.catalogo.command;

import com.saludsystem.catalogo.application.dtos.get.TipoConceptoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearTipoConceptoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarTipoConceptoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.TipoConceptoListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoCommandController extends GenericController<TipoConceptoDTO, CrearTipoConceptoDTO,
        ActualizarTipoConceptoDTO, UUID> {

    protected TipoConceptoCommandController(
            GenericService<TipoConceptoDTO, CrearTipoConceptoDTO, ActualizarTipoConceptoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoConceptoListResponse.class)))
    })
    public ListResponse<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
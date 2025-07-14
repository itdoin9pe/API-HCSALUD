package com.saludsystem.submodules.rest.controller.catalogo.query;

import com.saludsystem.submodules.catalogo.dtos.get.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.query.getAll.TipoConceptoAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.TipoConceptoByIdHandler;
import com.saludsystem.submodules.catalogo.response.TipoConceptoListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoQueryController {

    private final TipoConceptoByIdHandler byIdHandler;
    private final TipoConceptoAllHandler allHandler;

    public TipoConceptoQueryController(TipoConceptoByIdHandler byIdHandler, TipoConceptoAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetById/{id}")
    public TipoConceptoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TipoConceptoListResponse.class)))
    })
    public List<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, page, rows);
    }

}

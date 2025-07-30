package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.query.getAll.TipoConceptoAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.TipoConceptoByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.TipoConceptoListHandler;
import com.saludsystem.submodules.catalogo.response.TipoConceptoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoQueryController {

    private final TipoConceptoByIdHandler byIdHandler;
    private final TipoConceptoAllHandler allHandler;
    private final TipoConceptoListHandler listHandler;

    public TipoConceptoQueryController(TipoConceptoByIdHandler byIdHandler, TipoConceptoAllHandler allHandler, TipoConceptoListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<TipoConceptoDTO> getList() {
        return listHandler.execute();
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
    public ListResponse<TipoConceptoDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import com.saludsystem.submodules.mantenimiento.model.dtos.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.TipoGastoAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.TipoGastoByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.TipoGastoListHandler;
import com.saludsystem.submodules.mantenimiento.response.TIpoGastoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "ConceptosGastos")
@RestController
@RequestMapping("/api/ConceptosGastos")
public class TipoGastoQueryController {

    private final TipoGastoListHandler listHandler;
    private final TipoGastoByIdHandler byIdHandler;
    private final TipoGastoAllHandler allHandler;

    public TipoGastoQueryController(TipoGastoListHandler listHandler, TipoGastoByIdHandler byIdHandler, TipoGastoAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<TipoGastoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public TipoGastoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TIpoGastoListResponse.class)))
    })
    public ListResponse<TipoGastoDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                      @RequestParam(name = "Page") int page,
                                                      @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

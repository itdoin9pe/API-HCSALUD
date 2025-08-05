package com.saludsystem.submodules.core.configuracion.rest.controller.query;

import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;
import com.saludsystem.submodules.configuracion.query.getAll.TipoDocumentoByIdHandler;
import com.saludsystem.submodules.configuracion.query.getById.TipoDocumentoAllHandler;
import com.saludsystem.submodules.configuracion.query.getList.TipoDocumentoListHandler;
import com.saludsystem.submodules.configuracion.response.TipoDocumentoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoQueryController {

    private final TipoDocumentoAllHandler allHandler;
    private final TipoDocumentoByIdHandler byIdHandler;
    private final TipoDocumentoListHandler listHandler;

    public TipoDocumentoQueryController(TipoDocumentoAllHandler allHandler, TipoDocumentoByIdHandler byIdHandler, TipoDocumentoListHandler listHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<TipoDocumentoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public TipoDocumentoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TipoDocumentoListResponse.class)))
    })
    public ListResponse<TipoDocumentoDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                          @RequestParam(name = "Page") int page,
                                                          @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

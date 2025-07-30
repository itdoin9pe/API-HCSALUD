package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import com.saludsystem.submodules.mantenimiento.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.TarifarioAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.TarifarioByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.TarifarioListHandler;
import com.saludsystem.submodules.mantenimiento.response.TarifarioListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Tarifarios")
@RestController
@RequestMapping("/api/Tarifarios")
public class TarifarioQueryController {

    private final TarifarioAllHandler allHandler;
    private final TarifarioByIdHandler byIdHandler;
    private final TarifarioListHandler listHandler;

    public TarifarioQueryController(TarifarioAllHandler allHandler, TarifarioByIdHandler byIdHandler, TarifarioListHandler listHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<TarifarioDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public TarifarioDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TarifarioListResponse.class)))
    })
    public ListResponse<TarifarioDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                      @RequestParam(name = "Page") int page,
                                                      @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

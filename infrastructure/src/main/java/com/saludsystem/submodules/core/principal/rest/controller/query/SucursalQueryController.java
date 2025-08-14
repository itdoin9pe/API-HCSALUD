package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.response.AlergiaListResponse;
import com.saludsystem.submodules.principal.model.dtos.SucursalDTO;
import com.saludsystem.submodules.principal.query.getAll.SucursalAllHandler;
import com.saludsystem.submodules.principal.query.getById.SucursalByIdHandler;
import com.saludsystem.submodules.principal.query.getList.SucursalListHandler;
import com.saludsystem.submodules.principal.response.SucursalListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Sucursales")
@RequestMapping("/api/Sucursales")
@RestController
public class SucursalQueryController {

    private final SucursalListHandler listHandler;
    private final SucursalByIdHandler byIdHandler;
    private final SucursalAllHandler allHandler;

    public SucursalQueryController(SucursalListHandler listHandler, SucursalByIdHandler byIdHandler, SucursalAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<SucursalDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{sucursalId}")
    public SucursalDTO getById(@PathVariable UUID sucursalId) {
        return byIdHandler.execute(sucursalId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SucursalListResponse.class)))
    })
    public ListResponse<SucursalDTO> getAll(@RequestParam UUID hospitalId,
                                           @RequestParam(name = "Page") int page,
                                           @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

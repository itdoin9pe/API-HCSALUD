package com.saludsystem.submodules.core.movimiento.rest.controller.query;

import com.saludsystem.submodules.movimiento.model.dtos.CompraDetalleDTO;
import com.saludsystem.submodules.movimiento.query.getAll.CompraDetalleAllHandler;
import com.saludsystem.submodules.movimiento.query.getById.CompraDetalleByIdHandler;
import com.saludsystem.submodules.movimiento.query.getList.CompraDetalleListHandler;
import com.saludsystem.submodules.movimiento.response.CompraDetalleListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "ComprasDetalles")
@RestController
@RequestMapping("/api/ComprasDetalles")
public class CompraDetalleQueryController {

    private final CompraDetalleListHandler listHandler;
    private final CompraDetalleByIdHandler byIdHandler;
    private final CompraDetalleAllHandler allHandler;

    public CompraDetalleQueryController(CompraDetalleListHandler listHandler, CompraDetalleByIdHandler byIdHandler, CompraDetalleAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<CompraDetalleDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{compraDetalleId}")
    public CompraDetalleDTO getById(@PathVariable UUID compraDetalleId) {
        return byIdHandler.execute(compraDetalleId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CompraDetalleListResponse.class)))
    })
    public ListResponse<CompraDetalleDTO> getAll(@RequestParam UUID hospitalId,
                                           @RequestParam(name = "Page") int page,
                                           @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

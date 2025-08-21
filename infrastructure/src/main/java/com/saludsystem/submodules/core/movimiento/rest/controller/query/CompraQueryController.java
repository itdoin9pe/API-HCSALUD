package com.saludsystem.submodules.core.movimiento.rest.controller.query;

import com.saludsystem.submodules.movimiento.model.dtos.CompraDTO;
import com.saludsystem.submodules.movimiento.query.getAll.CompraAllHandler;
import com.saludsystem.submodules.movimiento.query.getById.CompraByIdHandler;
import com.saludsystem.submodules.movimiento.query.getList.CompraListHandler;
import com.saludsystem.submodules.movimiento.response.CompraListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Compras")
@RestController
@RequestMapping("/api/Compras")
public class CompraQueryController {

    private final CompraListHandler listHandler;
    private final CompraByIdHandler byIdHandler;
    private final CompraAllHandler allHandler;

    public CompraQueryController(CompraListHandler listHandler, CompraByIdHandler byIdHandler, CompraAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<CompraDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public CompraDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CompraListResponse.class)))
    })
    public ListResponse<CompraDTO> getAll(@RequestParam UUID hospitalId,
                                           @RequestParam(name = "Page") int page,
                                           @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

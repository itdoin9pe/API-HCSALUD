package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import com.saludsystem.submodules.mantenimiento.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.CuentaAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.CuentaByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.CuentaListHandler;
import com.saludsystem.submodules.mantenimiento.response.CuentaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaQueryController {

    private final CuentaByIdHandler byIdHandler;
    private final CuentaAllHandler allHandler;
    private final CuentaListHandler listHandler;

    public CuentaQueryController(CuentaByIdHandler byIdHandler, CuentaAllHandler allHandler, CuentaListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<CuentaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public CuentaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaListResponse.class)))
    })
    public ListResponse<CuentaDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                   @RequestParam(name = "Page") int page,
                                                   @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

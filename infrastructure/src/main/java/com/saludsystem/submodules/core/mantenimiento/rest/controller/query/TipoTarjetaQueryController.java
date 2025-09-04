package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import com.saludsystem.submodules.mantenimiento.model.dtos.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.TipoTarjetaAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.TipoTarjetaByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.TipoTarjetaListHandler;
import com.saludsystem.submodules.mantenimiento.response.TipoTarjetaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaQueryController {

    private final TipoTarjetaListHandler listHandler;
    private final TipoTarjetaByIdHandler byIdHandler;
    private final TipoTarjetaAllHandler allHandler;

    public TipoTarjetaQueryController(TipoTarjetaListHandler listHandler, TipoTarjetaByIdHandler byIdHandler, TipoTarjetaAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<TipoTarjetaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{tipoTarjetaId}")
    public TipoTarjetaDTO getById(@PathVariable UUID tipoTarjetaId) {
        return byIdHandler.execute(tipoTarjetaId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoTarjetaListResponse.class)))
    })
    public ListResponse<TipoTarjetaDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                        @RequestParam(name = "Page") int page,
                                                        @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}

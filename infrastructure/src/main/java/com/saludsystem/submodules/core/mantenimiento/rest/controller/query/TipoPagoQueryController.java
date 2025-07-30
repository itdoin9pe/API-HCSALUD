package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.TipoPagoAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.TipoPagoByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.TipoPagoListHandler;
import com.saludsystem.submodules.mantenimiento.response.TipoPagoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
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

@Tag(name = "TiposPagos")
@RestController
@RequestMapping("/api/TiposPagos")
public class TipoPagoQueryController {

    private final TipoPagoByIdHandler byIdHandler;
    private final TipoPagoAllHandler allHandler;
    private final TipoPagoListHandler listHandler;

    public TipoPagoQueryController(TipoPagoByIdHandler byIdHandler, TipoPagoAllHandler allHandler, TipoPagoListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<TipoPagoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public TipoPagoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoPagoListResponse.class)))
    })
    public ListResponse<TipoPagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

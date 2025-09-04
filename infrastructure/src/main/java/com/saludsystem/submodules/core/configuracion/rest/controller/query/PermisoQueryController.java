package com.saludsystem.submodules.core.configuracion.rest.controller.query;

import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;
import com.saludsystem.submodules.configuracion.query.getAll.PermisoByIdHandler;
import com.saludsystem.submodules.configuracion.query.getById.PermisoAllHandler;
import com.saludsystem.submodules.configuracion.query.getList.PermisoListHandler;
import com.saludsystem.submodules.configuracion.response.PermisoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Permisos")
@RestController
@RequestMapping("/api/Permisos")
public class PermisoQueryController {

    private final PermisoAllHandler allHandler;
    private final PermisoListHandler listHandler;
    private final PermisoByIdHandler byIdHandler;

    public PermisoQueryController(PermisoAllHandler allHandler, PermisoListHandler listHandler, PermisoByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetList")
    public List<PermisoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{permisoId}")
    public PermisoDTO getById(@PathVariable UUID permisoId) {
        return byIdHandler.execute(permisoId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermisoListResponse.class)))
    })
    public ListResponse<PermisoDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                    @RequestParam(name = "Page") int page,
                                                    @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

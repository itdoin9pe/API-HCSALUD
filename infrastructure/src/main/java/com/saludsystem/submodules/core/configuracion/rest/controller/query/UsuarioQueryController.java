package com.saludsystem.submodules.core.configuracion.rest.controller.query;

import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.query.getAll.UsuarioByIdHandler;
import com.saludsystem.submodules.configuracion.query.getById.UsuarioAllHandler;
import com.saludsystem.submodules.configuracion.query.getList.UsuarioListHandler;
import com.saludsystem.submodules.configuracion.response.UsuarioListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioQueryController {

    private final UsuarioByIdHandler byIdHandler;
    private final UsuarioAllHandler allHandler;
    private final UsuarioListHandler listHandler;

    public UsuarioQueryController(UsuarioByIdHandler byIdHandler, UsuarioAllHandler allHandler, UsuarioListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<UsuarioDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{Id}")
    public UsuarioDTO getById(@PathVariable UUID uuid) {
        return byIdHandler.execute(uuid);
    }

    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioListResponse.class)))
    })
    @GetMapping("/GetAllUsuario")
    public ListResponse<UsuarioDTO> getAll(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}

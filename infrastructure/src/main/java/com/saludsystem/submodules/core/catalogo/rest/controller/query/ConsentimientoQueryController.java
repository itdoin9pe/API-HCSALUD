package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.query.getAll.ConsentimientoAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.ConsentimientoByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.ConsentimientoListHandler;
import com.saludsystem.submodules.catalogo.response.ConsentimientoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoQueryController {

    private final ConsentimientoByIdHandler byIdHandler;
    private final ConsentimientoAllHandler allHandler;
    private final ConsentimientoListHandler listHandler;

    public ConsentimientoQueryController(ConsentimientoByIdHandler byIdHandler, ConsentimientoAllHandler allHandler, ConsentimientoListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<ConsentimientoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public ConsentimientoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ConsentimientoListResponse.class)))
    })
    public ListResponse<ConsentimientoDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}

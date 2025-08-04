package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;
import com.saludsystem.submodules.operaciones.query.getAll.UnidadAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.UnidadByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.UnidadListHandler;
import com.saludsystem.submodules.operaciones.response.UnidadListResponse;
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

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadQueryController {

    private final UnidadAllHandler allHandler;
    private final UnidadListHandler listHandler;
    private final UnidadByIdHandler byIdHandler;

    public UnidadQueryController(UnidadAllHandler allHandler, UnidadListHandler listHandler, UnidadByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetList")
    public List<UnidadDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public UnidadDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UnidadListResponse.class)))
    })
    public ListResponse<UnidadDTO> getAllPaginated(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

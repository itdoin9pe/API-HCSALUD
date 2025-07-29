package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import com.saludsystem.submodules.operaciones.model.dtos.get.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.query.getAll.CategoriaMaterialAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.CategoriaMaterialByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.CategoriaMaterialListHandler;
import com.saludsystem.submodules.operaciones.response.CategoriaMatListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatQueryController {

    private final CategoriaMaterialListHandler listHandler;
    private final CategoriaMaterialAllHandler allHandler;
    private final CategoriaMaterialByIdHandler byIdHandler;

    public CategoriaMatQueryController(CategoriaMaterialListHandler listHandler, CategoriaMaterialAllHandler allHandler, CategoriaMaterialByIdHandler byIdHandler) {
        this.listHandler = listHandler;
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetList")
    public List<CategoriaMatDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public CategoriaMatDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoriaMatListResponse.class)))
    })
    public ListResponse<CategoriaMatDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

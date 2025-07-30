package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.query.getAll.CategoriaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.CategoriaByIdHandler;
import com.saludsystem.submodules.catalogo.response.CategoriaListResponse;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaListService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Categorias")
@RestController
@RequestMapping("/api/Categorias")
public class CategoriaQueryController {

    private final CategoriaByIdHandler byIdHandler;
    private final CategoriaAllHandler allHandler;
    private final CategoriaListService listService;

    public CategoriaQueryController(CategoriaByIdHandler byIdHandler, CategoriaAllHandler allHandler, CategoriaListService listService) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listService = listService;
    }

    @GetMapping("/GetList")
    public List<CategoriaCreateCommand> getList() {
        return listService.execute();
    }

    @GetMapping("/GetById/{id}")
    public CategoriaCreateCommand getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoriaListResponse.class)))
    })
    public ListResponse<CategoriaCreateCommand> getAllPaginated(
            @RequestParam UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}

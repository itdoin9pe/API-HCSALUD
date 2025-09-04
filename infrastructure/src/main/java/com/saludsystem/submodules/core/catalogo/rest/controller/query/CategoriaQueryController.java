package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.query.getAll.CategoriaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.CategoriaByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.CategoriaListHandler;
import com.saludsystem.submodules.catalogo.response.CategoriaListResponse;
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
    private final CategoriaListHandler listHandler;

    public CategoriaQueryController(CategoriaByIdHandler byIdHandler, CategoriaAllHandler allHandler, CategoriaListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<CategoriaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{categoriaId}")
    public CategoriaDTO getById(@PathVariable UUID categoriaId) {
        return byIdHandler.execute(categoriaId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoriaListResponse.class)))
    })
    public ListResponse<CategoriaDTO> getAllPaginated(
            @RequestParam UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}

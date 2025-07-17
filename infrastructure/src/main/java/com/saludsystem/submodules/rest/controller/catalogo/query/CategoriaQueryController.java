package com.saludsystem.submodules.rest.controller.catalogo.query;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.query.getAll.CategoriaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.CategoriaByIdHandler;
import com.saludsystem.submodules.catalogo.response.CategoriaListResponse;
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

@Tag(name = "Categorias")
@RestController
@RequestMapping("/api/Categorias")
public class CategoriaQueryController {

    private final CategoriaByIdHandler byIdHandler;
    private final CategoriaAllHandler allHandler;

    public CategoriaQueryController(CategoriaByIdHandler byIdHandler, CategoriaAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetById/{id}")
    public CategoriaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoriaListResponse.class)))
    })
    public List<CategoriaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, page, rows);
    }
}
